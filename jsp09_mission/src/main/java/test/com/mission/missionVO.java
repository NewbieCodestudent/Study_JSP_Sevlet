package test.com.mission;

import java.io.Serializable;
import java.util.Objects;

public class missionVO implements Serializable {
	// major
	private int major_id;
	private String major_name;
	private int max_credit;
	private int min_credit;
	
	// department
	private int department_id;
	private String department_name;
	private String department_number;
	
	// student
	private int student_credit;
	private int student_id;
	private String student_name;
	@Override
	public int hashCode() {
		return Objects.hash(department_id, department_name, department_number, major_id, major_name, max_credit,
				min_credit, student_credit, student_id, student_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		missionVO other = (missionVO) obj;
		return department_id == other.department_id && Objects.equals(department_name, other.department_name)
				&& Objects.equals(department_number, other.department_number) && major_id == other.major_id
				&& Objects.equals(major_name, other.major_name) && max_credit == other.max_credit
				&& min_credit == other.min_credit && student_credit == other.student_credit
				&& student_id == other.student_id && Objects.equals(student_name, other.student_name);
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public int getMax_credit() {
		return max_credit;
	}
	public void setMax_credit(int max_credit) {
		this.max_credit = max_credit;
	}
	public int getMin_credit() {
		return min_credit;
	}
	public void setMin_credit(int min_credit) {
		this.min_credit = min_credit;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_number() {
		return department_number;
	}
	public void setDepartment_number(String department_number) {
		this.department_number = department_number;
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
	public String toString() {
		return "missionVO [major_id=" + major_id + ", major_name=" + major_name + ", max_credit=" + max_credit
				+ ", min_credit=" + min_credit + ", department_id=" + department_id + ", department_name="
				+ department_name + ", department_number=" + department_number + ", student_credit=" + student_credit
				+ ", student_id=" + student_id + ", student_name=" + student_name + "]";
	}
	
	
	
}
