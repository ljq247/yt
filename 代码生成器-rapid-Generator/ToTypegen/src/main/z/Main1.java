package main.z;

import java.math.BigDecimal;

import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("hell main");
		
		Column c=new Column();
		Table t=new Table();
		
		
		String  str="中国人:abcd";
			//	str=":";
		str="中国人";
		int indexOf = str.indexOf(":");
		
		String substring = str.substring(0,indexOf);
		System.out.println(indexOf);
		System.out.println(substring);
		
		
	}
}
