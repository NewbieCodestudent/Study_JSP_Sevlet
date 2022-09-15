package test.com.major.model;

import java.io.Serializable;
import java.util.Objects;

public class MajorVO implements Serializable {
	private String major_id;
	private String major_title;
	private int min_score;
	private int max_score;

	public String getMajor_id() {
		return major_id;
	}

	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}

	public String getMajor_title() {
		return major_title;
	}

	public void setMajor_title(String major_title) {
		this.major_title = major_title;
	}

	public int getMin_score() {
		return min_score;
	}

	public void setMin_score(int min_score) {
		this.min_score = min_score;
	}

	public int getMax_score() {
		return max_score;
	}

	public void setMax_score(int max_score) {
		this.max_score = max_score;
	}

	@Override
	public String toString() {
		return "MajorVO [major_id=" + major_id + ", major_title=" + major_title + ", min_score=" + min_score
				+ ", max_score=" + max_score + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(major_id, major_title, max_score, min_score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MajorVO other = (MajorVO) obj;
		return Objects.equals(major_id, other.major_id) && Objects.equals(major_title, other.major_title)
				&& max_score == other.max_score && min_score == other.min_score;
	}

}
