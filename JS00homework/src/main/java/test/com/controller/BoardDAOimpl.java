package test.com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<BoardVO> boardDummy() {
		List<BoardVO> vos = new ArrayList<BoardVO>();
		for (int i = 0; i < 10; i++) {
			BoardVO vo = new BoardVO();
			vo.setNum(i+1);
			vo.setTitle("java" + (i+1));
			vo.setContent("JSP_homework" + (i+1));
			vo.setWriter("lee" + (i+1));
			vos.add(vo);
		}
		return vos;
	}
	
}
