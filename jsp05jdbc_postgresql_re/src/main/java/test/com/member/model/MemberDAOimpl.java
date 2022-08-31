package test.com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAOimpl() {
		System.out.println("MemberDAOimpl()..");
		try {
			Class.forName(MemberDB_postgres.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//end constructor

	private void jdbcConnectionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			String sql = "select version() as version";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("version"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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

	//3
	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getProfile());
			
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		return flag;
	}
	

	@Override
	public int update(MemberVO vo) {
		System.out.println("update()...");
		System.out.println(vo);
		
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_UPDATE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getProfile());
			pstmt.setInt(6, vo.getNum());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete()...");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return flag;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()...");
		
		List<MemberVO> vos = new ArrayList<MemberVO>();

		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setProfile(rs.getString("profile"));
				vos.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		return vos;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);
		
		MemberVO vo2 = null;
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
				vo2.setProfile(rs.getString("profile"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return vo2;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		List<MemberVO> vos = new ArrayList<MemberVO>();
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			// �˻� : DQL
			if(searchKey.equals("name")) {
				pstmt = conn.prepareStatement(MemberDB_postgres.SQL_SEARCH_LIST_NAME);
			}else if(searchKey.equals("tel")) {
				pstmt = conn.prepareStatement(MemberDB_postgres.SQL_SEARCH_LIST_TEL);
			}
			
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setProfile(rs.getString("profile"));
				vos.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return vos;
	}
	@Override
	public MemberVO idCheck(MemberVO vo) {
		System.out.println("idCheck()...");
		System.out.println(vo);
		
		MemberVO vo2 = null;
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_ID_CHECK);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return vo2;
	}
	@Override
	public MemberVO login(MemberVO vo) {
		System.out.println("login()...");
		System.out.println(vo);
		
		MemberVO vo2 = null;
		
		try {
			conn = DriverManager.getConnection(MemberDB_postgres.URL, MemberDB_postgres.USER, MemberDB_postgres.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(MemberDB_postgres.SQL_LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		
		return vo2;
	}

}
