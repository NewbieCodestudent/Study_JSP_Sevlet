package test.com.d_model;

public interface DepDB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "HR";
	String PASSWORD = "hi123456";
	String SQL_SELECT_ALL = "select * from temp_dept order by department_id asc";
	String SQL_MAN_ID = "select distinct manager_id from employees";
	String SQL_LOC_ID = "select location_id from locations";
	String SQL_INSERT = "insert into temp_dept(department_id, department_name, manager_id, location_id)"
							+ " values(departments_seq.nextval, ?, ?, ?)";
	String SQL_DELETE = "delete from temp_dept where department_id = ?";
}
