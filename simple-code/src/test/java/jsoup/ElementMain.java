package jsoup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class ElementMain {

	
	/**
	 * 根据文件路径获取文件 并解析成document
	 * @throws IOException
	 */
	@Test
	public void getFileBypath() throws IOException {
		File in = new File("src/test/java/jsoup/file/in.html");
		Document doc = Jsoup.parse(in, "UTF-8", ""); 
		
//		Elements links = doc.select("a[href]"); //带有href属性的a元素
//		printElements(links);
//		Elements pngs = doc.select("img[src$=.png]");
//		  //扩展名为.png的图片
//
//		Element masthead = doc.select("div.masthead").first();
//		  //class等于masthead的div标签
//
//		Elements resultLinks = doc.select("h3.r  a"); //在h3元素之后的a元素
//		printElements(resultLinks);
//		
//		Elements els=doc.select("div a:gt(1)"); //选取a元素,从x+2开始计算开始计算
//		printElements(els);
		
		//select 在解析的时候, <a>下面不会再有<元素>
//		Elements  eldivs=doc.select("div[src]");  //select 会使用检查同级别div,还会遍历div下面所包涵的div
//		printElements(eldivs);
		
		Elements eldivs1=doc.select("div[src] :not(a)");
		printElements(eldivs1);
	}
	
	public void  printElements(Elements es){
		for(Element e: es){
			System.out.println(e.html());
			System.out.println("------------");
		}
	}
}
