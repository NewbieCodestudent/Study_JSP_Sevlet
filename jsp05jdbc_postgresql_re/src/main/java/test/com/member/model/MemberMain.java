package test.com.member.model;

import java.util.List;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class MemberMain {

	
	public static void main(String[] args) {
		System.out.println("Hello jdbc....");

		
		// 1. dao 객체생성
		MemberDAO dao = new MemberDAOimpl();
		
		// 내용수정,삭제,입력 : DML
		MemberVO vo = new MemberVO();
		vo.setId("cc330 ");
		vo.setPw("cc33300");
		vo.setName("ccc330");
		vo.setTel("cc330");
		
//		int result = dao.insert(vo);
//		System.out.println("result:" + result);

//		vo = new MemberVO();
//		vo.setId("admin99");
//		vo.setPw("hi123499");
//		vo.setName("kim99");
//		vo.setTel("0299");
//		vo.setNum(2);
//		int result = dao.update(vo);
//		System.out.println("result:"+result);
		
		vo = new MemberVO();
		vo.setNum(3);
		int result = dao.delete(vo);
		System.out.println("result:"+result);//1
		
		
		// 내용검색(모두,한개,검색어) : DQL
		List<MemberVO> vos = dao.selectAll();
		//for~
		for (MemberVO x : vos) {
			System.out.print(x.getNum()+" ");
			System.out.print(x.getId()+" ");
			System.out.print(x.getPw()+" ");
			System.out.print(x.getName()+" ");
			System.out.println(x.getTel());
		}
		
		System.out.println("===========");
		vo = new MemberVO();
		vo.setNum(2);
		MemberVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);
		System.out.println("===========");
		
		List<MemberVO> vos2 = dao.searchList("name","bb");
//		List<MemberVO> vos2 = dao.searchList("tel","33");
		for (MemberVO x : vos2) {
			System.out.println(x);
		}
		
	}// end main

	

}// end class
