package test.com.dept.model;

import java.io.Serializable;
import java.util.Objects;

public class DeptVO implements Serializable {
	private int dept_id;
	private String dept_name;
	private int mgr_id;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	@Override
	public String toString() {
		return "DeptVO [dept_id=" + dept_id + ", dept_name=" + dept_name + ", mgr_id=" + mgr_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept_id, dept_name, mgr_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptVO other = (DeptVO) obj;
		return dept_id == other.dept_id && Objects.equals(dept_name, other.dept_name) && mgr_id == other.mgr_id;
	}

}
