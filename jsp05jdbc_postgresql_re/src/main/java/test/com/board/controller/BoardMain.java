package test.com.board.controller;

import java.util.List;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

public class BoardMain {

	public static void main(String[] args) {
		System.out.println("Hello Board"); 

		
		BoardDAO dao = new BoardDAOimpl();
		
		//1.insert
		BoardVO vo = new BoardVO();
		vo.setTitle("java");
		vo.setContent("hello jdbc");
		vo.setWriter("yang");
//		int result = dao.insert(vo);
//		System.out.println("result:"+result);
		
		
		
//		//2.update
//		vo = new BoardVO();
//		vo.setNum(4);
//		vo.setTitle("title44");
//		vo.setContent("content44");
//		vo.setWriter("kim44");
//		
//		int result = dao.update(vo);
//		System.out.println("result:"+result);
		
//		//3.delete
//		vo = new BoardVO();
//		vo.setNum(1);
//		int result = dao.delete(vo);
//		System.out.println("result:"+result);
		
		//4.selectOne
		vo = new BoardVO();
		vo.setNum(10);
		BoardVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);
		
		//5.selectAll
		List<BoardVO> vos = dao.selectAll();
		for (BoardVO x : vos) {
			System.out.println(x);
		}
		
		//6.searchList
//		List<BoardVO> vos2 = dao.searchList("title", "ti");
		List<BoardVO> vos2 = dao.searchList("content", "llo");
//		List<BoardVO> vos2 = dao.searchList("writer", "ki");
		for (BoardVO x : vos2) {
			System.out.println(x);
		}
		

	}//end main

}//end class
