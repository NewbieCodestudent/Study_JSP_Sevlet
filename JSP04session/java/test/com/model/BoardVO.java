package test.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BoardVO implements Serializable{

	private int num;
	private String title;
	private String content;
	private String writer;
	private Date wdate = new Date();
	
	public BoardVO() {
		num = 1;
		title = "1번 게시글";
		content = "java";
		writer = "lee";
	}
	
	public BoardVO(int num, String title, String content, String writer) {
		System.out.println(num + title + content + writer + wdate);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, num, title, wdate, writer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return Objects.equals(content, other.content) && num == other.num && Objects.equals(title, other.title)
				&& Objects.equals(wdate, other.wdate) && Objects.equals(writer, other.writer);
	}
	
}
