package annotationLab.model;

import annotationLab.annotation.Column;
import annotationLab.annotation.TableName;


/**
 * 这是一张学生表
 * @author Administrator
 *
 */
@TableName(name="t_student")

public class Student {
	
	
	@Column(name="field_id")
	private int id; //学号
	
	
	@Column(name="field_name")
	private String name;//名字
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
