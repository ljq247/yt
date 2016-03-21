package com.netUtil;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class YouKu_GetText {

	
	public static void main(String[] args)throws Exception  {
		System.out.println( "你好");
		
		
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);		
        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm)
                .evictExpiredConnections()
                .evictIdleConnections(5L, TimeUnit.SECONDS)
                .build();
        
		// String requestURI =  "http://www.56.com/u90/v_NTMyMDI1MDM.html";
     //  String requestURI =  "http://v.youku.com/v_show/id_XNTc0NjIyMzMy.html?from=y1.2-1-103.3.12-1.1-1-1-11-0";
      String requestURI =  "http://v.youku.com/v_show/id_XMTM2NzAyMDMyNA==.html?from=y1.2-2-96.3.1-1.1-3-1-0-0";
         HttpGet request = new HttpGet(requestURI);  // 请求一个request url
         
         

         System.out.println("Executing request " + requestURI);
        try{
			         CloseableHttpResponse response = httpclient.execute(request);
			         try {
			             System.out.println("----------------------------------------");
			            // System.out.println(response.getStatusLine());
			             HttpEntity httpentity=  response.getEntity();
			             String  htmlString=EntityUtils.toString(httpentity) ;			         
			              
			            System.out.println("获取标题:");

			              System.out.println( getTitle(htmlString));
			            System.out.println("获取内容:");
			            System.out.println(getLable(htmlString));
			         
			          //  System.out.println(htmlString);
			         } finally {
			             response.close();
			         }
        } finally {
            httpclient.close();
        }

	}
	public  static String  getTitle(String s1){
		    int n1=  s1.indexOf("<h1 class=\"title\">");		    
		    int n2=s1.indexOf(">",n1);
		    int n3=s1.indexOf("</h1>",n2);
		   // System.out.println(n1+":"+n2+":"+n3);		    
		     return s1.substring(n2+1, n3);
	}
	public  static String  getLable(String s1){
	    int n1=  s1.indexOf("<div class=\"text\" id=\"text_short\">");		    
	    int n2=s1.indexOf(">",n1);
	    int n3=s1.indexOf("</div>",n2);
	   // System.out.println(n1+":"+n2+":"+n3);		    
	     return s1.substring(n2+1, n3);
}
}
