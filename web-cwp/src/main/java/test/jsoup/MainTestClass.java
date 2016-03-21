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
	 * ��ȡ���ӽ�Ŀ��Ϣ��
	 * @throws IOException
	 */
	//@Test
	public void getTvContent() throws IOException {
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/tv.htm").get();
		
		Elements  lis=  doc.select(".channel-list  li");
		


		for (Element li : lis) {
		   Element  img= li.getElementsByClass("c-img").first();
		    String src= img.attr("src");
		     if(src.isEmpty()) continue;  //����ַ���Ϊ��,������һ������
		   String title= li.select(".title a").first().text();
		   			
		   
		   String cname =li.select(".cname a").first().text();
	      System.out.println(src+"\n"+title+"\n"+cname); 
	      System.out.println("--------------------------");
		}
//
System.out.println("");
	}
	/**
	 * ��ȡ���ӽ�Ŀ��Ϣ��
	 * @throws IOException
	 */
	//@Test
	public void getCCtvContent() throws IOException {
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/cctv").get();
		
		Elements  lis=  doc.select(".channel-list  li");
		


		for (Element li : lis) {
		   Element  img= li.getElementsByClass("c-img").first();
		    String src= img.attr("src");
		     if(src.isEmpty()) continue;  //����ַ���Ϊ��,������һ������
		   String title= li.select(".title a").first().text();
		   			
		   
		   String cname =li.select(".cname a").first().text();
	      System.out.println(src+"\n"+title+"\n"+cname); 
	      System.out.println("--------------------------");
		}
//
System.out.println("");
	}
	/**
	 * ��ȡ�ط���Ŀ��Ϣ��
	 * @throws IOException
	 */
	@Test
	public void getLocalContent() throws IOException {
		//�����ַ  ʹ�õ��첽���صķ�ʽ,����ʹ�ü����������,����һ������:
		//http://www.fengyunlive.com/p/livejson/local?s=0&n=10
		Document doc = Jsoup.connect("http://www.fengyunlive.com/p/arts/local").get();
		
		Elements  lis=  doc.select(".channel-list  li");
		


		for (Element li : lis) {
		   Element  img= li.getElementsByClass("c-img").first();
		    String src= img.attr("src");
		     if(src.isEmpty()) continue;  //����ַ���Ϊ��,������һ������
		   String title= li.select(".title a").first().text();
		   			
		   
		   String cname =li.select(".cname a").first().text();
	      System.out.println(src+"\n"+title+"\n"+cname); 
	      System.out.println("--------------------------");
		}
	//
	System.out.println("");
	}
	
	/**
	 * channel-List �б�
	 * @throws IOException
	 */
	@Test
	public void  channelListContent() throws IOException {
		//�����ַ  ʹ�õ��첽���صķ�ʽ,����ʹ�ü����������,����һ������:
		//http://www.fengyunlive.com/p/livejson/local?s=0&n=10
		Document doc = Jsoup.connect("http://www.fengyunlive.com/channel-list").get();
		
		Elements  divs=  doc.select("#content  .list-wrap ");
		
	 
	
		List<Contry>  contryLIst= new ArrayList<Contry>();  //����һ������list
		
		
		for(Element div: divs){
		
			 Contry contry=new Contry();  //����һ�����ҷ���
			 Element h1_list_title= div.select("h1").first();  //����
			 
			 contry.setcName(h1_list_title.text());//����  ����
			 contry.seteName(  ChinaToEnglish.trans2PinYin(  contry.getcName() )  );
			 contry.setCreateTime(new java.util.Date());  //����ʱ��
			 
			 Elements  vicelist= div.select(".vice-list-wrap");// 
			 for(Element vice :vicelist){
				 City city= new City();
				 Element h2_list_title =vice.select("h2").first();//�����ۺ�
				 
				 city.setcName(h2_list_title.text());  //��������
				 city.seteName( ChinaToEnglish.trans2PinYin( city.getcName() ) );
				 city.setCreateTime(new java.util.Date()); //ʱ��
				// city.setC_id(c_id);  ���������ĸ�
				 
				 Elements  a_channels=  vice.select(".channel-wrap a");
				 for(Element chanel_a:a_channels) {	
					  Channel channel = new Channel();
					  channel.setcName( chanel_a.text() );
					  channel.seteName( ChinaToEnglish.trans2PinYin( channel.getcName() ));
					  channel.setCreateTime(new java.util.Date()); 
					  
					  city.getChannelList().add(channel);  //���channel;
					
				 }
				 
				 contry.getCityList().add(city);//��ӵ��б�
				
			 }
			//System.out.println(div.html() );
			 contryLIst.add(contry);  //��ӵ��б�
		}
		

		//
		System.out.println("i:"+contryLIst.size()+"��ӡ��ʼ:");
		
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
