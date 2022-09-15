package test.com.student;

import java.io.Serializable;
import java.util.Objects;

public class studentVO implements Serializable {
	// student
	private int student_credit;
	private int student_id;
	private String student_name;
	private int department_id;
	private int major_id;
	
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public int getStudent_credit() {
		return student_credit;
	}
	public void setStudent_credit(int student_credit) {
		this.student_credit = student_credit;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(department_id, major_id, student_credit, student_id, student_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		studentVO other = (studentVO) obj;
		return department_id == other.department_id && major_id == other.major_id
				&& student_credit == other.student_credit && student_id == other.student_id
				&& Objects.equals(student_name, other.student_name);
	}
	@Override
	public String toString() {
		return "studentVO [student_credit=" + student_credit + ", student_id=" + student_id + ", student_name="
				+ student_name + ", department_id=" + department_id + ", major_id=" + major_id + "]";
	}
	
	
	
}
