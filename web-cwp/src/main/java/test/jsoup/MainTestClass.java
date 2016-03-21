package test.jsoup;


import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.jsoup.china.to.english.ChinaToEnglish;
import test.jsoup.insertjdbc.model.Channel;
import test.jsoup.insertjdbc.model.City;
import test.jsoup.insertjdbc.model.Contry;

public class MainTestClass {
	
	 private static ApplicationContext  ctx;
	 @BeforeClass
	 public static void beforeClass(){
	  ctx = new ClassPathXmlApplicationContext("spring/springContext.xml");
	 System.out.println("i m beforClass");
	 }

	//@Test
	public void test() throws IOException {
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/art.htm").get();
		String title = doc.title();

		System.out.println(title);
		System.out.println("---------------");
		System.out.println(doc.html());
	}
	/**
	 * 获取卫视节目信息表
	 * @throws IOException
	 */
	//@Test
	public void getTvContent() throws IOException {
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/tv.htm").get();
		
		Elements  lis=  doc.select(".channel-list  li");
		


		for (Element li : lis) {
		   Element  img= li.getElementsByClass("c-img").first();
		    String src= img.attr("src");
		     if(src.isEmpty()) continue;  //如果字符串为空,遍历下一个数据
		   String title= li.select(".title a").first().text();
		   			
		   
		   String cname =li.select(".cname a").first().text();
	      System.out.println(src+"\n"+title+"\n"+cname); 
	      System.out.println("--------------------------");
		}
//
System.out.println("");
	}
	/**
	 * 获取央视节目信息表
	 * @throws IOException
	 */
	//@Test
	public void getCCtvContent() throws IOException {
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/cctv").get();
		
		Elements  lis=  doc.select(".channel-list  li");
		


		for (Element li : lis) {
		   Element  img= li.getElementsByClass("c-img").first();
		    String src= img.attr("src");
		     if(src.isEmpty()) continue;  //如果字符串为空,遍历下一个数据
		   String title= li.select(".title a").first().text();
		   			
		   
		   String cname =li.select(".cname a").first().text();
	      System.out.println(src+"\n"+title+"\n"+cname); 
	      System.out.println("--------------------------");
		}
//
System.out.println("");
	}
	/**
	 * 获取地方节目信息表
	 * @throws IOException
	 */
	@Test
	public void getLocalContent() throws IOException {
		//这个地址  使用的异步加载的方式,可以使用加入参数访问,返回一个数组:
		//http://www.fengyunlive.com/p/livejson/local?s=0&n=10
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/local").get();
		
		Elements  lis=  doc.select(".channel-list  li");
		


		for (Element li : lis) {
		   Element  img= li.getElementsByClass("c-img").first();
		    String src= img.attr("src");
		     if(src.isEmpty()) continue;  //如果字符串为空,遍历下一个数据
		   String title= li.select(".title a").first().text();
		   			
		   
		   String cname =li.select(".cname a").first().text();
	      System.out.println(src+"\n"+title+"\n"+cname); 
	      System.out.println("--------------------------");
		}
	//
	System.out.println("");
	}
	
	/**
	 * channel-List 列表
	 * @throws IOException
	 */
	@Test
	public void  channelListContent() throws IOException {
		//这个地址  使用的异步加载的方式,可以使用加入参数访问,返回一个数组:
		//http://www.fengyunlive.com/p/livejson/local?s=0&n=10
		Document doc = Jsoup.connect("http://www.fengyunlive.com/channel-list").get();
		
		Elements  divs=  doc.select("#content  .list-wrap ");
		
	 
	
		List<Contry>  contryLIst= new ArrayList<Contry>();  //创建一个国建list
		
		
		for(Element div: divs){
		
			 Contry contry=new Contry();  //创建一个国家分类
			 Element h1_list_title= div.select("h1").first();  //体育
			 
			 contry.setcName(h1_list_title.text());//设置  名称
			 contry.seteName(  ChinaToEnglish.trans2PinYin(  contry.getcName() )  );
			 contry.setCreateTime(new java.util.Date());  //设置时间
			 
			 Elements  vicelist= div.select(".vice-list-wrap");// 
			 for(Element vice :vicelist){
				 City city= new City();
				 Element h2_list_title =vice.select("h2").first();//体育综合
				 
				 city.setcName(h2_list_title.text());  //设置名字
				 city.seteName( ChinaToEnglish.trans2PinYin( city.getcName() ) );
				 city.setCreateTime(new java.util.Date()); //时间
				// city.setC_id(c_id);  设置属于哪个
				 
				 Elements  a_channels=  vice.select(".channel-wrap a");
				 for(Element chanel_a:a_channels) {	
					  Channel channel = new Channel();
					  channel.setcName( chanel_a.text() );
					  channel.seteName( ChinaToEnglish.trans2PinYin( channel.getcName() ));
					  channel.setCreateTime(new java.util.Date()); 
					  
					  city.getChannelList().add(channel);  //添加channel;
					
				 }
				 
				 contry.getCityList().add(city);//添加到列表
				
			 }
			//System.out.println(div.html() );
			 contryLIst.add(contry);  //添加到列表
		}
		

		//
		System.out.println("i:"+contryLIst.size()+"打印开始:");
		
		for(Contry contry: contryLIst){
			System.out.println(contry.toString());
			for(City  city: contry.getCityList()){
				System.out.println("----"+city.toString());
				for(Channel channel:city.getChannelList()){
					System.out.println("????????--"+channel.toString());
				}
			}
		}
		
	}
}
