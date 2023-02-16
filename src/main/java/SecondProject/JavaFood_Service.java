package SecondProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafood_DTO.AlbumDTO;
import javafood_DTO.CommentDTO;
import javafood_DTO.login_DTO;
import javafood_DTO.song_DTO;



public class JavaFood_Service {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//필드 공통으로 쓰는거 아니면 필드선언 자제해주세요~
	JavaFood_DAO dao;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//생성자   공통으로 사용하는 메소드 선언은 이곳에다가
	JavaFood_Service(){
		System.out.println("service 실행");
		dao = new JavaFood_DAO();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//세션에 있는 아이디 값을 가져오면 회원정보 출력
	public List<login_DTO> session_user(String id){
	List<login_DTO> list = dao.session(id);
	return list;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//다영

//	다영의 메소드(앨범목록) : 아직 vo 패키지에 안넣었음
//    public List<AlbumVO> Albumlist(){
//    	List<AlbumVO> Albumlist = dao.listAlbum(); 
//    	return Albumlist; JavaFood_Service(){
//	System.out.println("service 실행");
//	dao = new JavaFood_DAO();
//}
//    }


//	다영의 메소드(앨범목록리스트 불러오기) 
    public List<AlbumDTO > Albumlist(){
    	List<AlbumDTO> Albumlist = dao.listAlbum(); 
    	return Albumlist; 
    }

    //댓글 삭제 메소드
    public void delcomment(String id) {
    	dao.delcomment(id);
    }
    //댓글 전부 삭제
	public List<Integer> removeComment(int articleNO){
		List<Integer> articleNOList = dao.selectRemoveComment(articleNO);
		dao.deleteComment(articleNO);
		return articleNOList;
	}
    //댓글 등록 메소드
    public void addcomment(CommentDTO commentDTO) {
//    	dao.addcomment(commentDTO);
    	dao.insertComment(commentDTO);
    }
    
    //댓글 리스트 불러오는 메소드
    public List<CommentDTO> listComment() {
//    	List<CommentDTO> commentList = dao.listComment();
    	List<CommentDTO> commentList = dao.allComment();
    	return commentList;
    }
    
	public void javafood1(){
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//귀범 (차트 불러오기)
	public List<song_DTO> javafood2(){
		
		List<song_DTO> list = dao.listSong();
		
		return list;
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//범주 플레이 리스트 불러오기
	public List s_loadPL(String id)
	{
		System.out.println("JavaFood_Service의 s_loadPL 메서드 실행됨."); //확인용
		List s_playList = dao.loadPL(id);
		return s_playList;
	}
	
	//범주 페이징 서비스 (미완성)
//	public Map pl_getPagingList(int pageNum, int countPerPage, String id)
//	{
//		int start = 0;
//		int end = 0;
//		
//		start = (countPerPage*(pageNum-1) ) + 1;
//		end = start + countPerPage - 1;
//		List list = dao.loadPL(id, start, end);
//		
//		int totalCount = dao.pl_totalCount(id);
//		
//		Map map = new HashMap();
//		map.put("list", list);
//		map.put("totalCount", totalCount);
//		
//		return map;
//	}
	
	//범주 플레이 리스트 추가하기
	public void s_doAddList(String title, String explain, String id)
	{
		dao.addList(title, explain, id);
	}
	
	//범주 플레이 리스트 안의 내용 가져오기
	public List s_loadPLC(int PL_ID, String id)
	{
		List list = dao.loadPLC(PL_ID, id);
		
		return list;
	}
	
	//범주 플레이 리스트 안의 곡 제거하기
	public void s_doDeleteSong(int PL_ID, int listNumber)
	{
		dao.doDeleteSong(PL_ID, listNumber);
	}
	
	//범주 플레이 리스트 제거하기
	public void s_doDeleteList(int PL_ID, String id)
	{
		dao.deleteList(PL_ID, id);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//경용 로그인 
	/**
	 *로그인 페이지 
	 * @param i : 회원가입 확인 값
	 * @return map : 회원가입 페이지 이동값 리턴: 
	 */
	public Map<String, String> javafood4(String i){
		System.out.println("4번 로그인 페이지 실행");
		Map<String, String> map = new HashMap<String, String>();
		if(i!=null) {
			if(i.equals("O")) {
				map.put("membership", i);
			}
		}
		return map;
	}
	/**
	 * 회원목록 아이디 리스트
	 * @param i : 로그인 아이디 값
	 * @param j : 로그인 페스워드 값
	 * @return map : 로그인한 회원 정보 
	 */
	public Map<Object, Object> javafood4_1(String i, String j){
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
	/**
	 * 회원가입
	 * @param DTO : 회원가입 정보 DTO
	 */
	public int javafood4_2(login_DTO DTO){
		int i=0;
		try {
			i++;
			dao.addId(DTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 회원 정보 수정
	 * @param DTO : 회원가입 정보 DTO
	 */
	public int javafood4_3(login_DTO DTO) {
		int a =1;
		if(DTO!=null) dao.removeId(DTO);
		else a=0;
		return a;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	경용 마이페이지
	/**
	 * song1음악 리스트 출력
	 * @return  Map : song1 음악 리스트 리턴
	 */
	public Map<String, List<song_DTO>> javafood5(){
		List<song_DTO> list = dao.list();
		Map<String, List<song_DTO>> map = new HashMap<String, List<song_DTO>>();
		map.put("list", list);
		dao.list();
		return map;
	}
	/**
	 * 가수 및 음악 검색
	 * @param option : 가수 및 음악 값
	 * @param text : 검색내용
	 * @return  Map : 검색된 내용의 song1의 목록을 list로 가져옵니다
	 */
	public List<song_DTO> javafood5_1(String option, String text){
		return dao.Search(option, text);
	}
	/**
	 * 노래 조회수 증가
	 * @param id : 세션 아이디값 입력
	 * @param songnumber : 조회수 증가할 노래 번호입력
	 */
	public void javafood5_2(String id, String songnumber){
		dao.addhit(id, songnumber);
		dao.song1addhit(songnumber);
	}
	/**
	 * 아이디 값에 조회수증가된 노래 목록 가져오기
	 * @param id : 세션 아이디값 입력
	 * @return list : 아이디의 조회된 song1 노래목록 리턴 
	 */
	public List<song_DTO>javafood5_3(String id){
		return dao.uresong(id);
	}
	/**
	 * 노래 좋아요 증가
	 * @param songnumber : 좋아요 증가할 노래 번호입력
	 */
	public void javafood5_4(String songnumber) {
		dao.like(songnumber);
	}
//	//음악추가
//	public void javafood51(String a,String b,String c,String d){
//		dao.addsong1(a, b, c, d);
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준  장르별
	public List<song_DTO> javafood6(String song){
		System.out.println("6번 장르 실행");
		return dao.getGenre(song);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준 최신음악
	public List<song_DTO> javafood7(){
		System.out.println("7번 TOP 실행");
		return dao.popular_music();
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//용준 최신음악 좋아요
	public void javafood7(String songnumber) {
		dao.like_music(songnumber);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//태연 메인 
	public void javafoodm(){
		System.out.println("main 실행");
		
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
