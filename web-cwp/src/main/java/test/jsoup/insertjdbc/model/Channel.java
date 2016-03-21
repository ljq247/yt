package test.jsoup.insertjdbc.model;

import java.util.Date;

public class Channel {
	@Override
	public String toString() {
		return "Channel [id=" + id + ", cName=" + cName + ", eName=" + eName
				+ ", logo=" + logo + ", cityId=" + cityId + ", createTime="
				+ createTime + "]";
	}
	private int id;
	private String cName;
	private String eName;
	private String logo;
	private int cityId;
	private Date createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
