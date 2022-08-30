package test.com.member.model;

import java.util.Objects;

public class MemberVO {
	// 번호, 아이디, 비번, 이름, 폰번 속성 은닉해서 선언
	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	// 매개변수 없는 생성자 1개 생성
	
	public MemberVO() {
//		System.out.println("memberVO");
		num = 1;
		id = "asdf";
		pw = "1234";
		name = "kim";
		tel = "010-1234-5678";			
	}


	// 모든 속성을 매개변수로 하는 생성자 생성
	// Ctrl + Space
	
	public MemberVO(int num, String id, String pw, String name, String tel) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}
	
	// getter and setter 생성
	// 우클릭 > source > Generated getter and setter()을 누르고 Generate
	
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


	@Override
	public int hashCode() {
		return Objects.hash(id, name, num, pw, tel);
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
				&& Objects.equals(pw, other.pw) && Objects.equals(tel, other.tel);
	}



	
	// toString 재정의
	// 우클릭 > source > Generate toString
	
	@Override
	public String toString() {
		return "memberVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}	
	
	
	// 데이터클래스용 함수 재정의(해쉬코드)
	// 우클릭 > source > hashCode and equals
	
}
