package backup_code;

public class Javafood_add {
	
//	//음악추가
//	if(request.getParameter("javafood").equals("add")) {
//
//		String url = "https://www.melon.com/chart/month/index.htm?classCd=GN0000";
//		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();		
//		Elements e1 = doc.getElementsByAttributeValue("class", "checkEllipsis");
//		Elements e2 = doc.getElementsByAttributeValue("class", "ellipsis rank01").select("a");
//		Elements e3 = doc.getElementsByAttributeValue("class", "ellipsis rank03").select("a");
//		Elements e4 =  doc.getElementsByAttributeValue("class", "wrap").select("a").select("img");
//		JavaFood_DAO dao = new JavaFood_DAO();
//		int z=1;
//		for(int i=0; i<e4.size(); i++) {
//			System.out.println("제목 : "+(String)e2.get(i).text());
//			System.out.println("앨범 : "+(String)e3.get(i).text());
//			System.out.println("이미지 주소 : "+(String)e4.get(i).attr("src"));
//			System.out.println(i);
//			
//			
//			String b = (String)e2.get(i).text().replace("'", "").trim();
//			String c = (String)e3.get(i).text().replace("'", "").trim();
//			String d = (String)e4.get(i).attr("src").trim();
//			dao.addsong1(z,b, c, d);
//			z++;
//		}
		////////////////
//		z=1;
//		System.out.println(e1.size());
//		System.out.println(e2.size());
//		System.out.println(e3.size());
//		System.out.println(e4.size());
//		String b;
//			for(int i=0; i<e1.size(); i++) {
//			System.out.println("가수 : "+(String)e1.get(i).text());
//			String a = (String)e1.get(i).text().replace("'", "").trim();

//			String a = e1.get(i).toString();
//			System.out.println(a);
//			String result = "";
//			
//			while(true)
//			{
//				if(a.indexOf("<a") != -1)
//				{
//					int startNum = a.indexOf("이동\">") + 4;
//					int endNum = a.indexOf("</a>");
//					
//					if(result.equals("") )
//					{
//						result += a.substring(startNum, endNum);
//					}
//					else
//					{
//						result += ", " + a.substring(startNum, endNum);
//					}
//					a = a.substring(endNum + 4);
//				}
//				else
//				{
//					break;
//				}
//			}
//			System.out.println("가수 : " + result);
//			a=result;
////			list.add(a);
//			System.out.println((z)+"  "+a);
//			z++;
			
//		}
//		System.out.println("sldfhsladfhsakjdhfkjsadf : "+list.size());
//			for(int i=0; i<list.size(); i++) {
//			b =(String) list.get(i);
//			}
//		dao.addsong2(b,z);
//			z++;
//	}//if문 ("add")종료

}
