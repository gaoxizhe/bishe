package bean;

public class NoticeBean {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getIdent() {
		return ident;
	}
	private int id;
	private String title;
	private String content;
	private String ident;
	private String dates;
}
