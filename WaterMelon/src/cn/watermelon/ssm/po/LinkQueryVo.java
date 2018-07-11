package cn.watermelon.ssm.po;

/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:链接的包装对象 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	张子阳
 * @date	2018-4-18
 * @version 1.0
 */
public class LinkQueryVo {
	
	//商品信息
	private Link links;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private LinkCustom linksCustom;

	public Link getLinks() {
		return links;
	}

	public void setLinks(Link links) {
		this.links = links;
	}

	public LinkCustom getLinksCustom() {
		return linksCustom;
	}

	public void setLinksCustom(LinkCustom linksCustom) {
		this.linksCustom = linksCustom;
	}

	
	
	

}
