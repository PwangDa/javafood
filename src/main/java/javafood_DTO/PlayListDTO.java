package javafood_DTO;


public class PlayListDTO
{
	private String listTitle;
	private String listExplain;
	private String id;
	

	
	
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
	
	
	//생성자
	public PlayListDTO(){};
	public PlayListDTO(String title, String id)
	{
		this.listTitle = title;
		this.id = id;
	}
}
