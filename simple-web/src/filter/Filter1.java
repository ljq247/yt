package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1  implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		 System.out.println("----过滤器销毁----");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		System.err.println("过滤器1,dofilte执行");		
		//让其他过滤器 也调用dofilter方法
		arg2.doFilter(request, response);  		
		System.err.println("过滤器1,dofilte结束");		
	}
	/**
	 * litener 首先初始化,在运行过滤器
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub	
		System.out.println("过滤器1 初始化");
	}

}
