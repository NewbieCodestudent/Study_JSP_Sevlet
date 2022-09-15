package test.com.student.model;

import java.io.Serializable;
import java.util.Objects;

public class StVO implements Serializable {
	private int st_id;
	private String st_name;
	private int score;
	private String major_id;
	private int dept_id;
	private String major_title;
	private String dept_name;
	private String img_name;

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getMajor_title() {
		return major_title;
	}

	public void setMajor_title(String major_title) {
		this.major_title = major_title;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMajor_id() {
		return major_id;
	}

	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "StVO [st_id=" + st_id + ", st_name=" + st_name + ", score=" + score + ", major_id=" + major_id
				+ ", dept_id=" + dept_id + ", major_title=" + major_title + ", dept_name=" + dept_name + ", img_name="
				+ img_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept_id, dept_name, img_name, major_id, major_title, score, st_id, st_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StVO other = (StVO) obj;
		return dept_id == other.dept_id && Objects.equals(dept_name, other.dept_name)
				&& Objects.equals(img_name, other.img_name) && Objects.equals(major_id, other.major_id)
				&& Objects.equals(major_title, other.major_title) && score == other.score && st_id == other.st_id
				&& Objects.equals(st_name, other.st_name);
	}

}
