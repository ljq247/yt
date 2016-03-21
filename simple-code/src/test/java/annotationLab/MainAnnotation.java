package annotationLab;



import java.lang.reflect.Field;

import annotationLab.annotation.Column;
import annotationLab.annotation.TableName;
import annotationLab.model.Student;


/**
 * 这个方法是学习基本的 注解用法,  注入属性进去
 * 这里声明了两个 注解, tablename和Column, 在Student 里面使用了注解
 * 在main方法中得到注入进去的信息,并打印出来!
 * @author Administrator
 *
 */
public class MainAnnotation {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		System.out.println("hello world");
		//Student st=new Student();
		
		TableName tn= Student.class  .getAnnotation(TableName.class);
		
		 System.out.println(tn.name());		
				
		 Field[] fields= Student.class.getDeclaredFields();
		
		 for(Field field: fields){
				Column cm= field.getAnnotation( Column.class);	
				System.out.println(cm.name());
		 }
 
	System.out.println();

	
	}

}
