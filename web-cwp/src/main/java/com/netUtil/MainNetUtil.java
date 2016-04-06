package com.netUtil;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * ����������
 * 
 * @author Administrator
 *
 */
public class MainNetUtil {
	public static void main(String[] args)throws Exception  {
		System.out.println( "���");
		
		
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);		
        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm)
                .evictExpiredConnections()
                .evictIdleConnections(5L, TimeUnit.SECONDS)
                .build();
        
		
		// String requestURI =  "http://www.56.com/u90/v_NTMyMDI1MDM.html";
        String requestURI =  "http://www.fengyunlive.com/p/arts/local";
         HttpGet request = new HttpGet(requestURI);  // ����һ��request url
         
         

         System.out.println("Executing request " + requestURI);
        try{
			         CloseableHttpResponse response = httpclient.execute(request);
			         try {
			             System.out.println("----------------------------------------");
			            // System.out.println(response.getStatusLine());
			             HttpEntity httpentity=  response.getEntity();
			             String  htmlString=EntityUtils.toString(httpentity) ;			         
			              
			            System.out.println("��ȡ����:");
			           // System.out.println( getTitle(htmlString)  ); 
			            
			            System.out.println("��ȡ����:");
			          //  System.out.println( getLable(htmlString)  ); 
			             System.out.println(htmlString);
			         } finally {
			             response.close();
			         }
        } finally {
            httpclient.close();
        }

	}
	public  static String  getTitle(String s1){
		    int n1=  s1.indexOf("id=\"video_title_text\"");		    
		    int n2=s1.indexOf("title=",n1);
		    int n3=s1.indexOf("\">",n2);
		   // System.out.println(n1+":"+n2+":"+n3);		    
		     return s1.substring(n2+7, n3);
	}
	public  static String  getLable(String s1){
	    int n1=  s1.indexOf("<p class=\"label_txt\">");		    
	    int n2=s1.indexOf(">",n1);
	    int n3=s1.indexOf("</p>",n2);
	   // System.out.println(n1+":"+n2+":"+n3);		    
	     return s1.substring(n2+1, n3);
 
}   
}
