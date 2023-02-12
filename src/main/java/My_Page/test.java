package My_Page;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class test {

	public static void main(String[] args) throws IOException {
//		String url = "https://finance.naver.com/item/main.nhn?code=086900";
//		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
//		Elements e1 = doc.getElementsByAttributeValue("class", "no_today");
////		System.out.println(doc);
//		System.out.println(e1.get(0).select("span").get(0).text());
	
		String url = "https://www.melon.com/chart/index.htm";
		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
		Elements e1 = doc.getElementsByAttributeValue("class", "rank").select("span");
		
//		System.out.println(e1.get(1).text());
		
		Elements e2 = doc.getElementsByAttributeValue("class", "ellipsis rank01").select("a");
		
//		System.out.println(e2.get(0).text());
		
		Elements e3 = doc.getElementsByAttributeValue("class", "ellipsis rank03").select("a");

//		String e4 = doc.getElementsByAttributeValue("class", "wrap").select("a").select("img").get(0).attr("src");
		
		
		Elements e4 =  doc.getElementsByAttributeValue("class", "wrap").select("a").select("img");
//		System.out.println(e4.size());
		for(int i=0; i<e4.size(); i++) {
			System.out.println("순위 : "+e1.get(i+1).text());
			System.out.println("제목 : "+e2.get(i).text());
			System.out.println("가수 : "+e3.get(i).text());
			System.out.println("이미지 주소 : "+e4.get(i).attr("src"));
		}
		
		
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(e3);
//		System.out.println(e4);
//		System.out.println(e1.get(0).select("span").get(0).text());
	}

}
