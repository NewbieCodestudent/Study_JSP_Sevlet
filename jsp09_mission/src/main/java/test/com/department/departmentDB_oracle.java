package test.com.department;

public interface departmentDB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	String SQL_DEPT = "select * from department";
	String SQL_INSERT = "insert into department(department_id, department_name, department_number) values(department_id.nextval, ?, ?)";
}
