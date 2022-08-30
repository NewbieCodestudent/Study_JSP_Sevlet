package test.com.member.model;

public interface MemberDB_postgres {
	// MemberMain에서 사용하기 위한 DB인터페이스
	
	// 인터페이스는 기본이 public static final 이다. 
	/* public static final */ String DRIVER_NAME = "org.postgresql.Driver";
	String URL = "jdbc:postgresql://localhost:5432/postgres"; 
	String USER = "postgres";       // SQL_SELL에 들어가는 과정
	String PASSWORD = "admin1234";  // SQL_SELL 비밀번호 입력
	String SQL_SELECT_ALL = "select * from member order by num asc";  // SQL_SELL 내 명령어 입력, 정렬
	String SQL_INSERT = "insert into member(num, id, pw, name, tel)"  // SQL_SELL 내 명령어 입력, 배열 1행 추가문
									+ " values(nextval('seq_member'), ?, ?, ?, ?);";
	// ''을 ? 기호를 이용하여 pstmt에 maping 할 수 있다.
	// ? 순서대로 1,2,3,4가 된다.
	// maping 이후 메인에서 수정해 주면 실행할때마다 자동으로 추가된다.
	String SQL_UPDATE = "update member set id=?, pw=?, name=?, tel=? where num=?";
	String SQL_DELETE = "delete from member where num=?";
	String SQL_SELECT_ONE = "select * from member where num=?";
	String SQL_SEARCH_LIST_NAME = "select * from member where name like ?";
	String SQL_SEARCH_LIST_TEL = "select * from member where tel like ?";
}
