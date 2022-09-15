package test.com.model;

import java.io.Serializable;
import java.util.Objects;

public class EmpVO implements Serializable {
	private int employee_id;
	private String first_name;
	private String last_name;
	private int salary;
	private String job_id;
	private String department_id;
	private int emp_id;
	private String emp_name;
	private String dept_name;
	private String job_title;
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	
	@Override
	public String toString() {
		return "EmpVO [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", salary=" + salary + ", job_id=" + job_id + ", department_id=" + department_id + ", emp_id="
				+ emp_id + ", emp_name=" + emp_name + ", dept_name=" + dept_name + ", job_title=" + job_title + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(department_id, dept_name, emp_id, emp_name, employee_id, first_name, job_id, job_title,
				last_name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpVO other = (EmpVO) obj;
		return Objects.equals(department_id, other.department_id) && Objects.equals(dept_name, other.dept_name)
				&& emp_id == other.emp_id && Objects.equals(emp_name, other.emp_name)
				&& employee_id == other.employee_id && Objects.equals(first_name, other.first_name)
				&& Objects.equals(job_id, other.job_id) && Objects.equals(job_title, other.job_title)
				&& Objects.equals(last_name, other.last_name) && salary == other.salary;
	}
	
	
	
}
