package com.netUtil;

public class TestSearchString {
 
	
	 public static void main(String[] args) {
		    String str1 = "abcdefghijklmnabc"; 
		    // 从头开始查找是否存在指定的字符 
		    System.out.println(str1.indexOf("c")); 
		    // 从第四个字符位置开始往后继续查找 
		    System.out.println(str1.indexOf("c", 3)); 
		    //若指定字符串中没有该字符则系统返回-1 
		    System.out.println(str1.indexOf("x")); 
		    
		    
		    String s1="<h1 id=\"video_title_text\" title=\"濠江风云DVD国语\">濠江风云DVD国语</h1>";
		    System.out.println(s1);
		    
		    
		    int n1=  s1.indexOf("id=\"video_title_text\"");		    
		    int n2=s1.indexOf("title=",n1);
		    int n3=s1.indexOf("\">",n2);
		   // System.out.println(n1+":"+n2+":"+n3);		    
		    System.out.println(s1.substring(n2+7, n3));
	}

}
