package test.com.member.model;

import java.util.List;
import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class MemberMain_menu {

	public static void main(String[] args) {
		System.out.println("Hello jdbc...");

		// table과 같은 데이터 구조(전체 골격)를 생성, 삭제, 내용제거하는 명령어들 : DDL(Database Definition Language)
		// table 내 데이터(행과 열)를 내용수정, 삭제, 입력하는 명령어들 : DML(Data Manipulation Language)
		// table 내 데이터 내용검색(모두, 한개, 검색어)하는 명령어들 : DQL(Data Query Language)
		
		MemberDAO dao = new MemberDAOimpl();
		MemberVO vo = new MemberVO();
		
//		vo.setId("ccc");
//		vo.setPw("hiccc");
//		vo.setName("kimcc");
//		vo.setTel("03cc");
//		int result = dao.insert(vo);
//		System.out.println("result : "  + result);
		
//		vo = new MemberVO();
//		vo.setId("admin99");
//		vo.setPw("hi9999");
//		vo.setName("kim99");
//		vo.setTel("0299");
//		vo.setNum(16);
//		int result = dao.update(vo);
//		System.out.println("result : "  + result);

//		vo.setNum(15);
//		int result = dao.delete(vo);
//		System.out.println("result : "  + result);
		
//		vo.setNum(16);
//		MemberVO vo2 = dao.selectOne(vo);
//		System.out.println(vo2);
		
		List<MemberVO> vos2 = dao.searchList("name", "bb");
		for (MemberVO x : vos2) {
			System.out.println(x);
		}
		vos2 = dao.searchList("tel", "cc");
		for (MemberVO x : vos2) {
			System.out.println(x);
		}
		
		List<MemberVO> vos = dao.selectAll();
		for (MemberVO x : vos) {
			System.out.print(x.getNum() + " "); 
			System.out.print(x.getId() + " "); 
			System.out.print(x.getPw() + " "); 
			System.out.print(x.getName() + " "); 
			System.out.println(x.getTel()); 
		}
		
	}// end main

}// end class