package test.com.member.model;

import java.io.Serializable;
import java.util.Objects;

public class MemberVO implements Serializable {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String profile;

	public MemberVO() {
	}

	public MemberVO(int num, String id, String pw, String name, String tel, String profile) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.profile = profile;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getProfile() {
		return tel;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", profile=" + profile + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, num, pw, tel, profile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && num == other.num
				&& Objects.equals(pw, other.pw) && Objects.equals(tel, other.tel) && Objects.equals(profile, other.profile);
	}

}
