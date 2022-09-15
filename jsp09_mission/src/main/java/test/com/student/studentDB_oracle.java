package test.com.student;

public interface studentDB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	String SQL_STU = "select * from student";
	String SQL_INSERT = "insert into student(student_id, student_name, "
			+ "department_id, major_id, student_credit) values(student_id.nextval, ?, ?, ?, ?)";
	String SQL_DEPT_ID = "select department_id from department";
	String SQL_MAJOR_ID = "select major_id from major";
	String SQL_DELETE = "delete from student where student_id=?";
}
