package test.com.major;

public interface majorDB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	String SQL_MAJ = "select * from major";
	String SQL_INSERT = "insert into major(major_id, major_name, min_credit, max_credit) values(major_id.nextval, ?, ?, ?)";
}
