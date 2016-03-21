package jsoup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Jsoup_Main {

	
	/**
	 * 根据文件路径获取文件 并解析成document
	 * @throws IOException
	 */
	@Test
	public void getFileBypath() throws IOException {
		File in = new File("src/test/java/jsoup/file/in.html");
		Document doc = Jsoup.parse(in, "UTF-8", ""); 
		//System.out.println(doc.html());	
		
	    doc = Jsoup.connect("http://example.com").get();
	    System.out.println(doc.html() );
	}
}
