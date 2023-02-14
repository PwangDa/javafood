package javafood_DTO;


public class PlayListDTO
{
	private String listTitle;
	private String listExplain;
	private String id;
	private int pl_id;
	private String songName;
	private int listNumber;
	private int songNumber;
	private String artistName;
	
	
	
	
	//getter setter
	public String getListTitle() {
		return listTitle;
	}
	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}
	public String getListExplain() {
		return listExplain;
	}
	public void setListExplain(String listExplain) {
		this.listExplain = listExplain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPl_id() {
		return pl_id;
	}
	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public int getListNumber() {
		return listNumber;
	}
	public void setListNumber(int listNumber) {
		this.listNumber = listNumber;
	}
	public int getSongNumber() {
		return songNumber;
	}
	public void setSongNumber(int songNumber) {
		this.songNumber = songNumber;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	
	
	
	
	
	//생성자
	public PlayListDTO(){};
	
	public PlayListDTO(String title, String id, int pl_id) //플레이 리스트 불러올 때 쓰는 생성자
	{
		this.listTitle = title;
		this.id = id;
		this.pl_id = pl_id;
	}
	
	public PlayListDTO(int PL_ID, int listNumber, String songName, String plTitle, String plExplain, String artistName)
	{
		this.pl_id = PL_ID;
		this.listNumber = listNumber;
		this.songName = songName;
		this.listTitle = plTitle;
		this.listExplain = plExplain;
		this.artistName = artistName;
	}
}
