package cn.com.oa.birthdaybless_test.model;
//曹文平欢迎你使用本程序
import java.io.Serializable;
import cn.com.oa.cwputil.annotation.Th;
import java.util.Date;
/**
 *   
 */
public class TemporaryPersonManger  implements Serializable
{
	
	
	//columns START
	@Th(chinaName="")
	private java.lang.String id;// 
	@Th(chinaName="生日日期")
	private java.lang.String birthday;// 生日日期:只包括月日
	@Th(chinaName="手机号码")
	private java.lang.String phone;// 手机号码
	@Th(chinaName="机构")
	private java.lang.String organization;// 机构:这个字段从别的表引入
	@Th(chinaName="创建时间")
	private java.util.Date createTime;// 创建时间
	@Th(chinaName="姓名")
	private java.lang.String name;// 姓名
	//columns END
	
	// 构造函数
	public TemporaryPersonManger()
	{
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
		
	public java.lang.String getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(java.lang.String value) {
		this.birthday = value;
	}
	
		
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
		
	public java.lang.String getOrganization() {
		return this.organization;
	}
	
	public void setOrganization(java.lang.String value) {
		this.organization = value;
	}
	
		
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
		
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
		
	

}