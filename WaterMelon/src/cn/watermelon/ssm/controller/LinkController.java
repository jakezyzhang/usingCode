package cn.watermelon.ssm.controller;
/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:视图的操作 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	张子阳
 * @date	2018-4-18上午8:49:14
 * @version 1.0
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.watermelon.ssm.po.LinkCustom;
import cn.watermelon.ssm.po.LinkQueryVo;
import cn.watermelon.ssm.service.LinkService;
import cn.zzy.ssm.shortUrl.LongToShortUrl;

@Controller
public class LinkController {
	@Autowired
	private LinkService linkService;
	
	//显示数据库中有哪些长链接和对应的短链接
	@RequestMapping("/queryLink")
	public String queryLink(Model model,HttpServletRequest request) throws Exception{
		List<LinkCustom> findLinkList = linkService.findLinkList(null); 
		model.addAttribute("Linklist", findLinkList);
		
		return "watermelon";
	}
	
	//通过长链接生成对应的短链接，访问短链接会跳转对应的长链接
	@RequestMapping("/shortLink")
	public String InsertLink(Model model,HttpServletRequest request,LinkCustom linkCustom,String linklong) throws Exception{
//		System.out.println(linklong.length());
		Boolean flag = true;
		do{
			if(linklong.length()==0){
				String mistake = "网址不能为空";
				model.addAttribute("mistake", mistake);
				return "watermelon";
			}else{
				//生成短链接
				LongToShortUrl longToShortUrl = new LongToShortUrl();
				linkCustom.setLinklong(linklong);
				String shortUrl = longToShortUrl.GetShortUrl(linklong);
				
				LinkQueryVo linkQueryVo = new LinkQueryVo();
				linkQueryVo.setLinksCustom(linkCustom);
				//判断数据库中是否有现在输入的长链接对应的短链接
				if(linkService.findLinkShortUrlByLongUrl(linkQueryVo).size()==0){//如果没有对应长链接就将新得到的插入数据库
					linkCustom.setLinkshort(shortUrl);
					
					linkService.LinkInsert(linkCustom);
					
					model.addAttribute("shortUrl", shortUrl);
				}else if(linkService.findLinkShortUrlByLongUrl(linkQueryVo).size()!=0){//如果有数据就查出来
					List<LinkCustom> findLinkShortUrl = linkService.findLinkShortUrlByLongUrl(linkQueryVo);
					
					model.addAttribute("findLinkShortUrl", findLinkShortUrl);
				}
				
				model.addAttribute("LinkLongUrl", linklong);
				flag = false;
			}
		
		}while(flag);
		
		return "shortLinkUrl";
	}
}
