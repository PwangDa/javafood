package SecondProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Chart.SongDAO;
import javafood_DTO.AlbumDTO;
import javafood_DTO.CommentDTO;
import javafood_DTO.login_DTO;



public class JavaFood_Service {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//필드 공통으로 쓰는거 아니면 필드선언 자제해주세요~
	JavaFood_DAO dao;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//생선자   공통으로 사용하는 메소드 선언은 이곳에다가
	JavaFood_Service(){
		System.out.println("service 실행");
		dao = new JavaFood_DAO();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//다영

//	다영의 메소드(앨범목록) : 아직 vo 패키지에 안넣었음
//    public List<AlbumVO> Albumlist(){
//    	List<AlbumVO> Albumlist = dao.listAlbum(); 
//    	return Albumlist; 
//    }

//	다영의 메소드(앨범목록리스트 불러오기) 
    public List<AlbumDTO> Albumlist(){
    	List<AlbumDTO> Albumlist = dao.listAlbum(); 
    	return Albumlist; 
    }

    //댓글 삭제 메소드
    public void delcomment(String id) {
    	dao.delcomment(id);
    }
    //댓글 등록 메소드
    public void addcomment(CommentDTO commentDTO) {
    	dao.addcomment(commentDTO);
    }
    
    //댓글 리스트 불러오는 메소드
    public List<CommentDTO> listComment() {
    	List<CommentDTO> commentList = dao.listComment();
    	return commentList;
    }
    
	public void javafood1(){
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//귀범 (차트 불러오기)
	public List<javafood_DTO.login_DTO> javafood2(){
		
		List<javafood_DTO.login_DTO> list = dao.listSong();
		
		return list;
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//범주 
	public List s_loadPL(String id)
	{
		System.out.println("JavaFood_Service의 s_loadPL 메서드 실행됨."); //확인용
		List s_playList = dao.loadPL(id);
		return s_playList;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 로그인 
	//로그인 페이지
	public Map<String, String> javafood4(String i){
		System.out.println("4번 로그인 페이지 실행");
		System.out.println(i);
		Map<String, String> map = new HashMap<String, String>();
		if(i!=null) {
			if(i.equals("O")) {
				map.put("membership", i);
			}
		}else System.out.println("null 값");
		return map;
	}
	
	//회원목록 아이디 리스트
	public Map<Object, Object> javafood4_1(String i, String j){
		System.out.println("4_1번 로그인 페이지 실행");
		List<login_DTO> li = new ArrayList<login_DTO>();
		Map<Object, Object> ma = new HashMap<Object, Object>();
		int z=0;
		if(i!=null) {
			List<login_DTO> list = dao.listID();
			for(int q = 0; q<list.size(); q++) {
				if(list.get(q).getId().equals(i)) {
					z++;
					if(list.get(q).getPw().equals(j)) {
						z++;
						login_DTO dto = new login_DTO();
						dto.setNic(list.get(q).getNic());
						dto.setId(list.get(q).getId());
						dto.setPw(list.get(q).getPw());
						li.add(dto);
						ma.put("login", li);
					}
				}
			}
		}
		ma.put("log", z);
		return ma;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 마이페이지 
	public Map<String, List<login_DTO>> javafood5(){
		System.out.println("5번 my페이지 실행");
		List<login_DTO> list = dao.list();
		Map<String, List<login_DTO>> map = new HashMap<String, List<login_DTO>>();
		map.put("list", list);
		dao.list();
		return map;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준 
	public List<login_DTO> javafood6(String song){
		System.out.println("6번 장르 실행");
		List<login_DTO> list = null;
		
		if (song == null) {
			list = dao.list();
		} else {
			list = dao.getGenre(song);
		}
		return list;
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//태연 메인 
	public void javafoodm(){
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
