package test.com.member.model;

public interface MemberDB_postgres {
	String DRIVER_NAME = "org.postgresql.Driver";
	String URL = "jdbc:postgresql://localhost:5432/postgres";
	String USER = "postgres";
	String PASSWORD = "admin1234";
	String SQL_SELECT_ALL = "select * from member order by num asc";
	String SQL_INSERT = "insert into member(num,id,pw,name,tel,profile) values(nextval('seq_member'),?,?,?,?,?)";
	String SQL_UPDATE = "update member set id=?,pw=?,name=?,tel=?,profile=? where num=?";
	String SQL_DELETE = "delete from member where num=?";
	String SQL_SELECT_ONE = "select * from member where num=?";
	String SQL_ID_CHECK = "select * from member where id=?";
	String SQL_LOGIN = "select * from member where id=? and pw=?";
	String SQL_SEARCH_LIST_NAME = "select * from member where name like ?";
	String SQL_SEARCH_LIST_TEL = "select * from member where tel like ?";

}
