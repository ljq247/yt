package test.jsoup.insertjdbc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class City {

	private int id;
	private String  cName;
	private String eName;
	private Date createTime ;
	private int contry_id;
	private List<Channel> channelList=new ArrayList<Channel>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public List<Channel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
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
	public int getContry_id() {
		return contry_id;
	}
	public void setContry_id(int contry_id) {
		this.contry_id = contry_id;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", cName=" + cName + ", eName=" + eName
				+ ", createTime=" + createTime + ", contry_id=" + contry_id
				+ ", channelList=" + channelList + "]";
	}




}
