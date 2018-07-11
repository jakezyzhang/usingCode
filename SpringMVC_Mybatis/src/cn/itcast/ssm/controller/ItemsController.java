package cn.itcast.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	// 商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
		//测试forward后request是否可以共享
		
		System.out.println(request.getParameter("id"));

		// 调用service查找 数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");

		return modelAndView;

	}
	
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		//调用service根据商品id查询商品的信息
//		ItemsCustom editItems = itemsService.findItemsById(1);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		modelAndView.addObject("editItems",editItems);
//		
//		modelAndView.setViewName("items/editItems");
//		
//		return modelAndView;
//		
//		
//		
//	}
	
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer items_id) throws Exception{
		ItemsCustom editItems = itemsService.findItemsById(items_id);
		model.addAttribute("editItems", editItems);
		
		return "items/editItems";
	}
	
	
	//查询商品信息，输出json
	//itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数
	//如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception{
		
		//调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
	
	
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,
			@ModelAttribute("editItems")@Validated ItemsCustom itemsCustom,BindingResult bindingResult,
			MultipartFile items_pic)throws Exception {
		
		//获取校验错误信息
		if(bindingResult.hasErrors()){
			//输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for(ObjectError objectError:allErrors){
				//输出错误信息
//				System.out.println(objectError.getDefaultMessage());
			}
			
			model.addAttribute("allErrors", allErrors);
			return "items/editItems";
		}
		
		//原始名称
		String originalFilename = items_pic.getOriginalFilename();
		
		//上传图片
		if(items_pic != null && originalFilename != null && originalFilename.length() > 0){
			
			
			//存储图片的物理地址
			String pic_path = "F:\\SSM_picture\\pic\\";
			
			//新的图片的名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);
			
			//将新图片名称写成ItemsCustom中
			itemsCustom.setPic(newFileName);
		}
		
		
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
//		itemsCustom.getCreatetime();
		
		//重定向到商品查询列表
		return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
//		return "success";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        dateFormat.setLenient(false);
//	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//
//	 }  
	
	@RequestMapping("/itemsbyname")
	public ModelAndView Itemsbyname(HttpServletRequest request,String name) throws Exception {
		// 调用service查找 数据库，查询商品列表
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setName(name);
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> itemsNameList = itemsService.selectItemsByName(itemsQueryVo);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsNameList", itemsNameList);
		

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		 modelAndView.setViewName("items/itemsNameList");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
	//批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		for(int i = 0; i < items_id.length; i ++){
			System.out.println("items_id" + items_id[i]);
		}
		return "success";
	}
	
	
	// 批量修改商品提交
	// 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中itemsList属性中。
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(Model model,ItemsQueryVo itemsQueryVo,Integer id,ItemsCustom itemsCustom)
			throws Exception {
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		itemsService.updateItems(id, itemsCustom);
		model.addAttribute("itemsList", itemsList);
		return "items/editItemsQuery";
	}
	
}
