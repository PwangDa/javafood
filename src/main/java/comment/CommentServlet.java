package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/artistcomment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		CommentDAO dao = new CommentDAO();
		
		String command = request.getParameter("command");
		
		if("addcomment".equals(command)) {
			String id_1 = request.getParameter("id");
			String cont_1 = request.getParameter("cont");
			
			CommentVO vo = new CommentVO();
			vo.setComment_id(id_1);
			vo.setComment_cont(cont_1);
			
			dao.addcomment(vo);
		}else if("delcommnet".equals(command)) {
			
			String id_2 = request.getParameter("id");
			System.out.println("delete 확인"+id_2);
			dao.delcomment(id_2);
		}
		
		List<CommentVO> list = dao.listComment();
		
	      out.write("\r\n");
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write(" <script>\r\n");
	      out.write("        function fn_sendComment(){\r\n");
	      out.write("            frmComment.method = \"post\";\r\n");
	      out.write("            frmComment.action = \"artistcomment\";\r\n");
	      out.write("            frmComment.submit();\r\n");
	      out.write("        }\r\n");
	      out.write("  </script>\r\n");
	      out.write("  <style>\r\n");
	      out.write("        body{\r\n");
	      out.write("            background-color: black;\r\n");
	      out.write("            margin: 0;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        div{\r\n");
	      out.write("            /* border: 1px solid white; */\r\n");
	      out.write("            color : white;\r\n");
	      out.write("            /* vertical-align: middle; */\r\n");
	      out.write("        }\r\n");
	      out.write("        header{\r\n");
	      out.write("            background-color: black;\r\n");
	      out.write("            color: white;\r\n");
	      out.write("            width: 100%;\r\n");
	      out.write("            position:fixed;\r\n");
	      out.write("            /* top: 0; */\r\n");
	      out.write("            /* display: flex; */\r\n");
	      out.write("            height: 35px;\r\n");
	      out.write("            padding: 2px;\r\n");
	      out.write("            z-index: 1;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .namu{\r\n");
	      out.write("            text-decoration: none;\r\n");
	      out.write("            color: white;\r\n");
	      out.write("        }\r\n");
	      out.write("        \r\n");
	      out.write("        #cont{\r\n");
	      out.write("            background-image:\r\n");
	      out.write("            linear-gradient(\r\n");
	      out.write("                to bottom,\r\n");
	      out.write("                rgba(0, 0, 0, 0) 10%,\r\n");
	      out.write("                rgba(0, 0, 0, 0.25) 25%,\r\n");
	      out.write("                rgba(0, 0, 0, 0.5) 50%,\r\n");
	      out.write("                rgba(0, 0, 0, 0.75) 75%,\r\n");
	      out.write("                rgb(0, 0, 0) 100%\r\n");
	      out.write("            ),\r\n");
	      out.write("            url(\"https://w.namu.la/s/35d25c55317e8d29d11fa9fa1a41348ee63d3a010f356d360a9dcdc95513885e4c3143831db6c08d2e387e6db67702b7a8631594931a4200d1d5eb23b2d2153d359217d8630e5821bf8ec71ff102cbfead094989d147315b5f1f38bb42304b78bf798ebd30fb0e36f557e05d33780995\") ;\r\n");
	      out.write("            background-repeat: no-repeat;\r\n");
	      out.write("            background-size: cover;\r\n");
	      out.write("            background-position: center;\r\n");
	      out.write("            height: 550px;     \r\n");
	      out.write("            position: relative;\r\n");
	      out.write("        }\r\n");
	      out.write("        \r\n");
	      out.write("        .text1{\r\n");
	      out.write("            color : white;\r\n");
	      out.write("            padding: 0px 10px;\r\n");
	      out.write("            position : absolute;\r\n");
	      out.write("            bottom : 0;\r\n");
	      out.write("        }\r\n");
	      out.write("        \r\n");
	      out.write("        #cont1{\r\n");
	      out.write("            display : flex;\r\n");
	      out.write("            justify-content: center;\r\n");
	      out.write("            height: 80px;\r\n");
	      out.write("        }\r\n");
	      out.write("        .box1{\r\n");
	      out.write("            width: 170px;\r\n");
	      out.write("            height: 60px;\r\n");
	      out.write("            margin: 0 15px;\r\n");
	      out.write("            text-align: left;     \r\n");
	      out.write("\r\n");
	      out.write("        }\r\n");
	      out.write("        \r\n");
	      out.write("        hr{\r\n");
	      out.write("            width: 62%;\r\n");
	      out.write("            border: 0;\r\n");
	      out.write("            border-top: 1px solid rgb(98, 98, 98);\r\n");
	      out.write("        }\r\n");
	      out.write("        .img1{\r\n");
	      out.write("            width: 60px;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .comment{\r\n");
	      out.write("            display: flex;\r\n");
	      out.write("            justify-content: center;\r\n");
	      out.write("        }\r\n");
	      out.write("        .text2{\r\n");
	      out.write("            padding-top: 20px;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        textarea{\r\n");
	      out.write("            width: 500px;\r\n");
	      out.write("            height: 110px;\r\n");
	      out.write("            padding: 10px;\r\n");
	      out.write("            margin: 11px;\r\n");
	      out.write("            box-sizing: border-box;\r\n");
	      out.write("            border-radius: 15px;\r\n");
	      out.write("            color: white;\r\n");
	      out.write("            border: none;\r\n");
	      out.write("            resize: none;\r\n");
	      out.write("            background-color: rgb(70, 70, 70);\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .input1{\r\n");
	      out.write("            background-color: rgb(70, 70, 70);\r\n");
	      out.write("            color: white;\r\n");
	      out.write("            border-radius: 15px;\r\n");
	      out.write("            border: none;\r\n");
	      out.write("            height: 19px;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .image1{\r\n");
	      out.write("            width: 90px;\r\n");
	      out.write("            display: block;\r\n");
	      out.write("            border-radius: 70%;\r\n");
	      out.write("            margin : 5px 0px 5px 40px;\r\n");
	      out.write("            \r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .btn{\r\n");
	      out.write("            color:white;\r\n");
	      out.write("            background-color:rgb(70, 70, 70);\r\n");
	      out.write("            padding: 15px 30px;\r\n");
	      out.write("            height: 110px;\r\n");
	      out.write("            margin: 10px;\r\n");
	      out.write("            border-radius: 15px;\r\n");
	      out.write("            border: none;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .btn:active{\r\n");
	      out.write("            transform: scale(1.1);\r\n");
	      out.write("        }\r\n");
	      out.write("        .btn:hover{\r\n");
	      out.write("            background-color:rgba(173, 173, 173, 0.545);\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .command{\r\n");
	      out.write("            text-align: center;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .cont2{\r\n");
	      out.write("            /* border: 1px solid rgb(70, 70, 70); */\r\n");
	      out.write("            width: 500px;\r\n");
	      out.write("            margin: 11px;\r\n");
	      out.write("            padding: 10px;\r\n");
	      out.write("            box-sizing: border-box;\r\n");
	      out.write("            border-radius: 15px;\r\n");
	      out.write("            text-align: left;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .id2{\r\n");
	      out.write("            /* border: 1px solid rgb(70, 70, 70); */\r\n");
	      out.write("            color :rgb(113, 113, 113);\r\n");
	      out.write("            border-radius: 15px;\r\n");
	      out.write("            width: 130px;\r\n");
	      out.write("            font-size: 15px;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("        .image2{\r\n");
	      out.write("            width: 75px;\r\n");
	      out.write("            border-radius: 70%;          \r\n");
	      out.write("        }\r\n");
	      out.write("        .date1{\r\n");
	      out.write("            /* border: 1px solid rgb(70, 70, 70); */\r\n");
	      out.write("            border-radius: 15px;\r\n");
	      out.write("            margin: 11px;\r\n");
	      out.write("            padding: 1px;\r\n");
	      out.write("            text-align: right;\r\n");
	      out.write("            color :rgb(113, 113, 113);\r\n");
	      out.write("            font-size: 13px;\r\n");
	      out.write("        }\r\n");
	      out.write("\r\n");
	      out.write("    </style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("    <header id =\"menu\">\r\n");
	      out.write("        메뉴상단바입니다\r\n");
	      out.write("    </header>\r\n");
	      out.write("    <div id = \"home\">\r\n");
	      out.write("        <div id = \"cont\" class = \"contain\">\r\n");
	      out.write("            <div class = \"text1\">\r\n");
	      out.write("                <h1>아이유(IU)</h1>\r\n");
	      out.write("                <p>아이유는 대한민국의 가수이자 배우이다. 배우로 활동할 때는 본명을 사용한다. \r\n");
	      out.write("                <br>'아이유'라는 예명은 'I'와 'You'를 합친 합성어로 '너와 내가 음악으로 하나가 된다.'라는 의미이다.</p>\r\n");
	      out.write("                <div> <a class=\"namu\" target=\"_blank\" href=\"https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0\">출처:namuwiki</a></div>\r\n");
	      out.write("            </div>\r\n");
	      out.write("        </div>\r\n");
	      out.write("        <div id =\"cont1_1\">\r\n");
	      out.write("            <h2 style=\"text-align: center; margin: 13px;\">음악</h2>\r\n");
	      out.write("            <div id = \"cont1\">\r\n");
	      out.write("                <div class = \"box1\">\r\n");
	      out.write("                    <img class=\"img1\" src=\"data:image/jpeg;base64,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\">\r\n");
	      out.write("                </div>\r\n");
	      out.write("                <div class = \"box1 text2\">Blueming</div>\r\n");
	      out.write("                <div class = \"box1 text2\">아이유(IU)</div>\r\n");
	      out.write("                <div class = \"box1 text2\">Love Poem</div>\r\n");
	      out.write("            </div>\r\n");
	      out.write("            <hr>\r\n");
	      out.write("            <div id = \"cont1\">\r\n");
	      out.write("                <div class = \"box1\">\r\n");
	      out.write("                    <img class=\"img1\" src=\"https://w.namu.la/s/db95e8529db90e3ad7c75b6d7ea8506b7a4a6f0d547810cc6ab1aa8c7f063f848a56c4f93636c7fa53e81f5fe00a3374df82f3d4b38372669e466cad41c3ea9f6d8599a7e1cc92e480151edd39e8d11f9fe8f557a20aca3229ccf1ece31b874b\">\r\n");
	      out.write("                </div>\r\n");
	      out.write("                <div class = \"box1 text2\">Celebrity</div>\r\n");
	      out.write("                <div class = \"box1 text2\">아이유(IU)</div>\r\n");
	      out.write("                <div class = \"box1 text2\">IU 5th Album 'LILAC'</div>\r\n");
	      out.write("            </div>\r\n");
	      out.write("            <hr>\r\n");
	      out.write("            <div id = \"cont1\">\r\n");
	      out.write("                <div class = \"box1\">\r\n");
	      out.write("                    <img class=\"img1\" src=\"https://w.namu.la/s/4a817b8f4ec9caca4027a6991651a401d683a7691f1926bd60e59908f306d439f7cc251af5ef263a6f0a249e831d5d9cf641855bf590dadd86869ff941aad8dc2afc989539e89d163404cf11be3510f863a34fc06e8d02ae94a305a76b623d8e2981bfae68ff2a4a7cc419ef60e59d9f\">\r\n");
	      out.write("                </div>\r\n");
	      out.write("                <div class = \"box1 text2\">Twenty-three</div>\r\n");
	      out.write("                <div class = \"box1 text2\">아이유(IU)</div>\r\n");
	      out.write("                <div class = \"box1 text2\">CHAT-SHIRE</div>\r\n");
	      out.write("            </div>\r\n");
	      out.write("            <hr>\r\n");
	      out.write("            <div id = \"cont1\">\r\n");
	      out.write("                <div class = \"box1\">\r\n");
	      out.write("                    <img class=\"img1\" src=\"https://w.namu.la/s/dd10984aec9e0100e8472908ccf9f3d5be391ae2f0e7f962706df43e750fc092d386e38f2f238ca014202108ecc9ee63d7237a18804a56b32c0c0b4f48d65229cf9c0fee9a61326cc53c12f939c2aaeecfcfb8fcf71831154a974db7ca2416fbfa31eec0ca0b899915b8b7e2e2d90a6d\">\r\n");
	      out.write("                </div>\r\n");
	      out.write("                <div class = \"box1 text2\">가을 아침</div>\r\n");
	      out.write("                <div class = \"box1 text2\">아이유(IU)</div>\r\n");
	      out.write("                <div class = \"box1 text2\">꽃-갈피 둘</div>\r\n");
	      out.write("            </div>\r\n");
	      out.write("            <hr>\r\n");
	      out.write("            <div id = \"cont1\">\r\n");
	      out.write("                <div class = \"box1\">\r\n");
	      out.write("                    <img class=\"img1\" src=\"https://w.namu.la/s/60894337b62385bc3d8c11603b2e0fba73ed6d8df3c48a96c944ece7217cca79ab3cba348cc7d9e8664a62f7dea101d3727fde9e914ec32580ac38786a2470db2c10f235140d97142bf7175ae917b5d4958de6fa44cf18cc9ed8bf7a25082b2211f507ad7937ff0439737434950618c7\">\r\n");
	      out.write("                </div>\r\n");
	      out.write("                <div class = \"box1 text2\">겨울잠</div>\r\n");
	      out.write("                <div class = \"box1 text2\">아이유(IU)</div>\r\n");
	      out.write("                <div class = \"box1 text2\">조각집</div>\r\n");
	      out.write("            </div>\r\n");
	      out.write("        </div>\r\n");
	      out.write("        <div>\r\n");
	      out.write("            <h3 style=\"text-align: center; margin: 0px;\">댓글</h3>\r\n");
	      out.write("            <form name=\"frmComment\">\r\n");
	      out.write("                <div class=\"comment\">\r\n");
	      out.write("                    <div class=\"text2\">\r\n");
	      out.write("                        <img class=\"image1\" src=\"http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png\">\r\n");
	      out.write("                        <input class=\"input1\" type=\"text\" name=\"id\" placeholder=\" ID를 입력해주세요\">\r\n");
	      out.write("                    </div>\r\n");
	      out.write("                    <div class=\"text2\">\r\n");
	      out.write("                        <textarea name=\"cont\" placeholder=\"*게시물의 저작권 등 분쟁, 개인정보 노출로 인한 책임은 작성자 또는 게시자에게 있음을 유의해 주세요.\"></textarea>\r\n");
	      out.write("                    </div>\r\n");
	      out.write("                    <div class=\"text2\">\r\n");
	      out.write("                        <button class=\"btn\" type=\"button\" onclick=\"fn_sendComment()\"> 등록 </button>\r\n");
	      out.write("                    </div>\r\n");
	      out.write("                    <input type =\"hidden\" name=\"command\" value=\"addcomment\">\r\n");
	      out.write("            </form>\r\n");
	      out.write("            </div>\r\n");
	      out.write("            <div class=\"command\">\r\n");
	      out.write("                    <hr>\r\n");
	      for(int i= 0; i<list.size(); i++) {
	    	  CommentVO vo = list.get(i);
	    	  
	    	  String num = vo.getComment_num();
	    	  String id = vo.getComment_id();
	    	  String cont = vo.getComment_cont();
	    	  Date date = vo.getComment_Date();
	    	  
	    	  out.write("                    <div class=\"comment\">\r\n");
	          out.write("                        <div class=\"text2 cont2_1\">\r\n");
	          out.write("                            <img class=\"image2\" src=\"http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png\">\r\n");
	          out.write("                            <div class='id2'>"+id+"</div>\r\n");
	          out.write("                        </div>\r\n");
	          out.write("                        <div class=\"text2\">\r\n");
	          out.write("                            <div class='cont2'>"+cont+"</div>\r\n");
	          out.write("                            <div class='date1'>"+date+"</div>\r\n");
	          out.write("                        </div>\r\n");
	          out.write("                        <div class=\"text2\">\r\n");
	          out.write("                            <a href='/javafood_team/artistcomment?command=delcommnet&id="+id+"'><button class='btn' type='button'>삭제</button></a>\r\n");
	          out.write("                        </div>\r\n");
	          out.write("                    </div>\r\n");
	    	  
	    	  
	      }
	      out.write("            </div>\r\n");
	      out.write("        </div>\r\n");
	      out.write("\r\n");
	      out.write("    </div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>");
		
	}

}
