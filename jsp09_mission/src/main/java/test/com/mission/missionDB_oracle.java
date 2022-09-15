package test.com.mission;

public interface missionDB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "KOSTA";
	String PASSWORD = "hi123456";
	String SQL_SELECT_ALL_VIEW = "select * from mission_view";
	String SQL_SELECT_ALL_JOIN = "select student_id, student_name,"
								+ " s.department_id, department_name, department_number,"
								+ " s.major_id, major_name, min_credit, max_credit, student_credit"
								+ " from student s join department d on s.department_id = d.department_id"
								+ " join major m on s.major_id = m.major_id"
								+ " order by student_id asc";
	String SQL_DEPT = "select * from department";
	String SQL_MAJ = "select * from major";
	String SQL_STU = "select * from student";
}
