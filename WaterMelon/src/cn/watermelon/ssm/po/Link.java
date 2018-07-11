package cn.watermelon.ssm.po;
/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:Link的pojo </p>
 * <p>Company: www.itcast.com</p> 
 * @author	张子阳
 * @date	2018-4-18
 * @version 1.0
 */
public class Link {
    private Integer id;

    private String linklong;

    private String linkshort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinklong() {
        return linklong;
    }

    public void setLinklong(String linklong) {
        this.linklong = linklong == null ? null : linklong.trim();
    }

    public String getLinkshort() {
        return linkshort;
    }

    public void setLinkshort(String linkshort) {
        this.linkshort = linkshort == null ? null : linkshort.trim();
    }
}