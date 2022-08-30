package test.com.board.model;

import java.util.List;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

public class BoardMain {

	public static void main(String[] args) {
		System.out.println("Hello Board");
		
		BoardDAO dao = new BoardDAOimpl();
		BoardVO vo = new BoardVO();
		// ==============================================
		// 1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색
		// 종료시[x]를 눌러주세요.
		// ==============================================
		// 메뉴를 선택하세요 :
		// 1
		// =============================================
		// 1.글입력 페이지
		// =============================================
		// 제목 :
		// 내용 :
		// 작성자 :
		// 입력성공/실패
		// ==============================================
		// 1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색
		// 종료시[x]를 눌러주세요.
		// ==============================================
		// 2.글수정 페이지
		// 글번호 :
		// 제목 :
		// 내용 :
		// 작성자 :
		// 입력성공/실패
		
		// insert test
//		vo.setTitle("java");
//		vo.setContent("study");
//		vo.setWriter("kim");
//		int result =  dao.insert(vo);
		
		// update test
//		vo.setTitle("SQL");
//		vo.setContent("STUDY");
//		vo.setWriter("lee");
//		vo.setNum(6);
//		int result = dao.update(vo);
		
		// delete test
//		vo.setNum(6);
//		int result = dao.delete(vo);
		
//		vo.setNum(3);
//		BoardVO vo2 = dao.searchOne(vo);
//		System.out.println(vo2);
		
		List<BoardVO> vos2 = dao.searchList("title", "java");
		for (BoardVO x : vos2) {
			System.out.println(x);
		}
		
		vos2 = dao.searchList("content", "sutdy");
		for (BoardVO x : vos2) {
			System.out.println(x);
		}
		
		vos2 = dao.searchList("writer", "kim");
		for (BoardVO x : vos2) {
			System.out.println(x);
		}
		
		List<BoardVO> list = dao.selectAll();
		for (BoardVO x : list) {
			System.out.println(x);
		}
		
	}//end main

}//end class
