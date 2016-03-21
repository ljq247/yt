package test.jsoup.insertjdbc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contry {

	private int id;
	private String  cName;
	private String eName;
	private Date createTime ;
	private List<City> cityList=new ArrayList<City>();
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Contry [id=" + id + ", cName=" + cName + ", eName=" + eName
				+ ", createTime=" + createTime + "]";
	}




}
