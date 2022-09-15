package test.com.department;

import java.io.Serializable;
import java.util.Objects;

public class departmentVO implements Serializable {
	// department
	private int department_id;
	private String department_name;
	private String department_number;
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
	@Override
	public int hashCode() {
		return Objects.hash(department_id, department_name, department_number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		departmentVO other = (departmentVO) obj;
		return department_id == other.department_id && Objects.equals(department_name, other.department_name)
				&& Objects.equals(department_number, other.department_number);
	}
	@Override
	public String toString() {
		return "departmentVO [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_number=" + department_number + "]";
	}

	
}
