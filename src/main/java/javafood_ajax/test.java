package javafood_ajax;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.util.*;

import SecondProject.JavaFood_DAO;

public class test {

	public static void main(String[] args) throws IOException {
//		String url = "https://finance.naver.com/item/main.nhn?code=086900";
//		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
//		Elements e1 = doc.getElementsByAttributeValue("class", "no_today");
////		System.out.println(doc);
//		System.out.println(e1.get(0).select("span").get(0).text());
	
		
		String url = "https://www.melon.com/chart/index.htm";
		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
		Elements e1 = doc.getElementsByAttributeValue("class", "ellipsis rank02").select("a");
		Elements e2 = doc.getElementsByAttributeValue("class", "ellipsis rank01").select("a");
		Elements e3 = doc.getElementsByAttributeValue("class", "ellipsis rank03").select("a");
		Elements e4 =  doc.getElementsByAttributeValue("class", "wrap").select("a").select("img");
		System.out.println("da1");
		JavaFood_DAO dao = new JavaFood_DAO();
		System.out.println("da2");
		for(int i=0; i<e4.size(); i++) {
			System.out.println("가수 : "+(String)e1.get(i).text());
			System.out.println("제목 : "+(String)e2.get(i).text());
			System.out.println("앨범 : "+(String)e3.get(i).text());
			System.out.println("이미지 주소 : "+(String)e4.get(i).attr("src"));
			
			String a = (String)e1.get(i).text();
			String b = (String)e2.get(i).text();
			String c = (String)e3.get(i).text();
			String d = (String)e4.get(i).attr("src");
			
			System.out.println("가수 : "+a);
			System.out.println("제목 : "+b);
			System.out.println("앨범 : "+c);
			System.out.println("이미지 주소 : "+d);
		}
		
		
	}

}
