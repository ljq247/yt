package cn.com.oa.birthdaybless_test.model;
//曹文平欢迎你使用本程序
import java.io.Serializable;
import cn.com.oa.cwputil.annotation.Th;
import java.util.Date;
/**
 *   
 */
public class StudentTest  implements Serializable
{
	
	
	//columns START
	@Th(chinaName="")
	private java.lang.String id;// 
	@Th(chinaName="姓名")
	private java.lang.String name;// 姓名
	@Th(chinaName="年龄")
	private java.lang.Integer age;// 年龄
	@Th(chinaName="创建时间")
	private java.util.Date createTime;// 创建时间
	@Th(chinaName="状态")
	private java.lang.Short status;// 状态:0标示删除,1表示存在
	@Th(chinaName="兴趣")
	private java.lang.String interesting;// 兴趣:可以是多个!
	//columns END
	
	// 构造函数
	public StudentTest()
	{
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
		
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
		
	public java.lang.Integer getAge() {
		return this.age;
	}
	
	public void setAge(java.lang.Integer value) {
		this.age = value;
	}
	
		
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
		
	public java.lang.Short getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Short value) {
		this.status = value;
	}
	
		
	public java.lang.String getInteresting() {
		return this.interesting;
	}
	
	public void setInteresting(java.lang.String value) {
		this.interesting = value;
	}
	
		
	

}