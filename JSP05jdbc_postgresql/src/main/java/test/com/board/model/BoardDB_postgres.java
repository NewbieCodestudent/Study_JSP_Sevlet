package test.com.board.model;

public interface BoardDB_postgres {
	// MemberMain에서 사용하기 위한 DB인터페이스
	
	// 인터페이스는 기본이 public static final 이다. 
	/* public static final */ String DRIVER_NAME = "org.postgresql.Driver";  // driver 클래스의 주소
	String URL = "jdbc:postgresql://localhost:5432/golfzon"; 
	String USER = "kosta";
	String PASSWORD = "hi123456";
	String SQL_SELECT_ALL = "select * from board order by num asc";
	String SQL_INSERT = "insert into board(num, title, content, writer, wdate)"
			+ " values(nextval('seq_board'), ?, ?, ?, 'now()')";
	String SQL_UPDATE = "update board set title=?, content=?, writer=?, wdate='now()' where num=?";
	String SQL_DELETE = "delete from board where num=?";
	String SQL_SELECT_ONE = "select * from board where num=?";
	String SQL_SEARCH_LIST_TITLE = "select * from board where title like ?";
	String SQL_SEARCH_LIST_CONTENT = "select * from board where content like ?";
	String SQL_SEARCH_LIST_WRITER = "select * from board where writer like ?";
}
