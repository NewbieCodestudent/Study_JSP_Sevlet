package test.com.model;

public interface EmpDB_oracle {
	
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "HR";
	String PASSWORD = "hi123456";
	String SQL_SELECT_ALL = "select * from temp_emp order by employee_id asc";
	String SQL_DEPT_ID = "select department_id from temp_dept";
	String SQL_JOB_ID = "select job_id from temp_job";
	String SQL_INSERT = "insert into temp_emp(employee_id, first_name, last_name, salary, job_id, department_id)"
							+ " values(employees_seq.nextval, ?, ?, ?, ?, ?)";
	String SQL_SELECT_ALL_VIEW = "select * from join_emp_dept_view";
	String SQL_SELECT_ALL_JOIN = "select employee_id emp_id, first_name||' '||last_name emp_name, salary, dept.department_name dept_name,"
								+ "j.job_title from temp_emp emp join temp_dept dept on emp.department_id = dept.department_id "
								+ "join jobs j on j.job_id = emp.job_id";
	
}
