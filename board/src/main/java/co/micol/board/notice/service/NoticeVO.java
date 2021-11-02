package co.micol.board.notice.service;

import java.sql.Date;

public class NoticeVO {

	private int nId;
	private String Id;
	private String name;
	private Date writeDate;		//java sql Date를 사용 //시분초를 다룬다. 
	private String title;
	private String contents;
	private String hit;
	
public NoticeVO(){
		
	}

public int getnId() {
	return nId;
}

public void setnId(int nId) {
	this.nId = nId;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getWriteDate() {
	return writeDate;
}

public void setWriteDate(Date writeDate) {
	this.writeDate = writeDate;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContents() {
	return contents;
}

public void setContents(String contents) {
	this.contents = contents;
}

public String getHit() {
	return hit;
}

public void setHit(String hit) {
	this.hit = hit;
}

		
}
