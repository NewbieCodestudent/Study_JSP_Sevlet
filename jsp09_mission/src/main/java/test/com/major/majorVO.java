package test.com.major;

import java.io.Serializable;
import java.util.Objects;

public class majorVO implements Serializable {
	// major
	private int major_id;
	private String major_name;
	private int min_credit;
	private int max_credit;
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
	@Override
	public int hashCode() {
		return Objects.hash(major_id, major_name, max_credit, min_credit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		majorVO other = (majorVO) obj;
		return major_id == other.major_id && Objects.equals(major_name, other.major_name)
				&& max_credit == other.max_credit && min_credit == other.min_credit;
	}
	@Override
	public String toString() {
		return "majorVO [major_id=" + major_id + ", major_name=" + major_name + ", max_credit=" + max_credit
				+ ", min_credit=" + min_credit + "]";
	}

	
	
}
