package com.netUtil;

import java.io.IOException;




import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {
	
	public static void main(String[] args) {
		
				try {
				
					Document doc1 = Jsoup.connect("http://baike.baidu.com/link?url=-ItgO4Eb73-EBYQqwKYlfhu4kn-ulpC0O6gx3_ZHdBRbmVirOOiabifJGOTy9YxtFQG-Krn_iddiWzHzmxQm1a").get();
					String title = doc1.title();
					System.out.println(title);
					

					Element content =  doc1.getElementById("searchForm");
					Elements links = content.getElementsByTag("a");
					for (Element link : links) {
					  String linkHref = link.attr("href");
					  System.out.println(linkHref);
					  String linkText = link.text();
					  System.out.println(linkText);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
