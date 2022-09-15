package test.com.student.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.dbinfo.DB_oracle;
import test.com.dept.model.DeptVO;

public class StDAOimpl implements StDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public StDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(StVO vo) {
		System.out.println("insert()....");
		System.out.println(vo);

		int flag = 0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_ST_INSERT_IMG);
			pstmt.setString(1, vo.getSt_name());
			pstmt.setInt(2, vo.getScore());
			pstmt.setString(3, vo.getMajor_id());
			pstmt.setInt(4, vo.getDept_id());
			pstmt.setString(5, vo.getImg_name());
			
			flag = pstmt.executeUpdate();
			
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
		return flag;
	}

	@Override
	public List<StVO> selectAll() {
		System.out.println("selectAll()....");

		List<StVO> vos = new ArrayList<StVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.DEPT_MAJOR_ST_VIEW);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StVO vo = new StVO();
				vo.setSt_id(rs.getInt("st_id"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setScore(rs.getInt("score"));
				vo.setMajor_title(rs.getString("major_title"));
				vo.setDept_name(rs.getString("dept_name"));
				vo.setImg_name(rs.getString("img_name"));
				vos.add(vo);
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
		return vos;
	}

	@Override
	public List<Integer> json_dept_id() {
		System.out.println("json_dept_id()....");
		List<Integer> ids = new ArrayList<Integer>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_DEPT_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ids.add(rs.getInt("dept_id"));
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

		return ids;
	}

	@Override
	public List<String> json_major_id() {
		System.out.println("json_major_id()....");
		List<String> ids = new ArrayList<String>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_MAJOR_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ids.add(rs.getString("major_id"));
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

		return ids;
	}

}
