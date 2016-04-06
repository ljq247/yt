package cwp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpMethod;

public class Main1 {
	public static void main(String[] args) {
	
	     // 核心应用类

	      HttpClient httpClient = new DefaultHttpClient();

	        // HTTP请求

	        HttpUriRequest request =

	                new HttpGet("http://www.linuxidc.com/Linux/2015-06/119100.htm");

	        // 打印请求信息

	        System.out.println(request.getRequestLine());

	        try {

	            // 发送请求，返回响应

	            HttpResponse response = httpClient.execute(request);

	            // 打印响应信息

	            System.out.println(response.getStatusLine());
	            

	        } catch (ClientProtocolException e) {

	            // 协议错误

	            e.printStackTrace();

	        } catch (IOException e) {

	            // 网络异常

	            e.printStackTrace();

	        }
	}

}
