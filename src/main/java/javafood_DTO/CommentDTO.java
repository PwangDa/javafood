package javafood_DTO;

import java.sql.Date;

public class CommentDTO {
	
	private String comment_num;
	private String comment_id;
	private String comment_cont;
	private Date comment_Date;
	
	public String getComment_num() {
		return comment_num;
	}
	public void setComment_num(String comment_num) {
		this.comment_num = comment_num;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_cont() {
		return comment_cont;
	}
	public void setComment_cont(String comment_cont) {
		this.comment_cont = comment_cont;
	}
	public Date getComment_Date() {
		return comment_Date;
	}
	public void setComment_Date(Date comment_Date) {
		this.comment_Date = comment_Date;
	}


}
