package test.com.dbinfo;

public interface DB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	
	String DEPT_MAJOR_ST_VIEW = "select * from dept_major_st_view order by st_id desc";
	
	String SQL_ST_INSERT = "insert into student(st_id,st_name,score,major_id,dept_id) "
			+ "values(seq_student.nextval,?,?,?,?)";
	String SQL_ST_INSERT_IMG = "insert into student(st_id,st_name,score,major_id,dept_id,img_name) "
			+ "values(seq_student.nextval,?,?,?,?,?)";
	
	String SQL_DEPT_ID = "select dept_id from dept";
	String SQL_MAJOR_ID = "select major_id from major";
	
	String SQL_DEPT_SELECT_ALL = "select * from dept order by dept_id desc";
	String SQL_DEPT_INSERT = "insert into dept(dept_id,dept_name,mgr_id) "
			+ "values(seq_dept.nextval,?,?)";
	String SQL_ST_ID = "select st_id from student";
	
	String SQL_MAJOR_SELECT_ALL = "select * from major order by major_id desc";
	String SQL_MAJOR_INSERT = "insert into major(major_id,major_title,min_score,max_score) "
			+ "values(?,?,?,?)";
	
}
