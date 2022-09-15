package test.com.dept.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.dbinfo.DB_oracle;

public class DeptDAOimpl implements DeptDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DeptDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(DeptVO vo) {
		System.out.println("insert()....");
		System.out.println(vo);

		int flag = 0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_DEPT_INSERT);
			pstmt.setString(1, vo.getDept_name());
			pstmt.setInt(2, vo.getMgr_id());
			
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
	public List<DeptVO> selectAll() {
		System.out.println("selectAll()....");

		List<DeptVO> vos = new ArrayList<DeptVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_DEPT_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDept_id(rs.getInt("dept_id"));
				vo.setDept_name(rs.getString("dept_name"));
				vo.setMgr_id(rs.getInt("mgr_id"));
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
	public List<Integer> json_st_id() {
		System.out.println("json_st_id()....");
		List<Integer> ids = new ArrayList<Integer>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_ST_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ids.add(rs.getInt("st_id"));
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
