package test.com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.com.board.model.BoardDB_postgres;

public class BoardDAOimpl implements BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAOimpl() {
		// 1. DRIVER에 접속
		try {
			Class.forName(BoardDB_postgres.DRIVER_NAME);
			System.out.println("Driver successed...");

//			driver에 잘 들어가 졌는지 확인
//			jdbcConnectionTest();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. jdbcConnectionTest() 생성하여 잘 들어가지는지 확인
	private void jdbcConnectionTest() {
		// 변수는 전역변수로 선언
		
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER,
					BoardDB_postgres.PASSWORD);
			String sql = "select version() as version";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("version"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
	}

	// 3. insert에 입력 코드작성
	@Override
	public int insert(BoardVO vo) {
//		System.out.println("insert");
		System.out.println(vo);
		// return값 생성
		int flag = 0;
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER,
					BoardDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		return flag;
	}

	@Override
	public int update(BoardVO vo) {
//		System.out.println("update");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER,
					BoardDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getNum());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		return flag;
	}
	
	@Override
	public int delete(BoardVO vo) {
//		System.out.println("delete");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER,
					BoardDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		return flag;
	}

	@Override
	public BoardVO searchOne(BoardVO vo) {
//		System.out.println("searchOne");
		BoardVO vo2 = new BoardVO();
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
//		System.out.println("searchAll");
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
			pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getDate("wdate"));
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<BoardVO> searchList(String searchkey, String searchWord) {
//		System.out.println("searchList");
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DriverManager.getConnection(BoardDB_postgres.URL, BoardDB_postgres.USER, BoardDB_postgres.PASSWORD);
			if (searchkey.equals("title")) {
				pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SEARCH_LIST_TITLE);
			} else if (searchkey.equals("content")) {
				pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SEARCH_LIST_CONTENT);
			} else if (searchkey.equals("writer")) {
				pstmt = conn.prepareStatement(BoardDB_postgres.SQL_SEARCH_LIST_WRITER);
			}
			pstmt.setString(1, "%" + searchWord + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getDate("wdate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public Map<Integer, BoardVO> test() {
		System.out.println("test");
		Map<Integer, BoardVO> m = new HashMap<Integer, BoardVO>();
		for (int i = 0; i < 4; i++) {
			BoardVO vo = new BoardVO();
			vo.setNum(i+1);
			vo.setTitle("title" + (i+1));
			vo.setContent("java" + (i+1));
			vo.setWriter("lee" + (i+1));
			m.put(i, vo);
		}
		return m;
	}

}
