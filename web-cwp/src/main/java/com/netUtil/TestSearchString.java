package com.netUtil;

public class TestSearchString {
 
	
	 public static void main(String[] args) {
		    String str1 = "abcdefghijklmnabc"; 
		    // ��ͷ��ʼ�����Ƿ����ָ�����ַ� 
		    System.out.println(str1.indexOf("c")); 
		    // �ӵ��ĸ��ַ�λ�ÿ�ʼ����������� 
		    System.out.println(str1.indexOf("c", 3)); 
		    //��ָ���ַ�����û�и��ַ���ϵͳ����-1 
		    System.out.println(str1.indexOf("x")); 
		    
		    
		    String s1="<h1 id=\"video_title_text\" title=\"婽�����DVD����\">婽�����DVD����</h1>";
		    System.out.println(s1);
		    
		    
		    int n1=  s1.indexOf("id=\"video_title_text\"");		    
		    int n2=s1.indexOf("title=",n1);
		    int n3=s1.indexOf("\">",n2);
		   // System.out.println(n1+":"+n2+":"+n3);		    
		    System.out.println(s1.substring(n2+7, n3));
	}

}
