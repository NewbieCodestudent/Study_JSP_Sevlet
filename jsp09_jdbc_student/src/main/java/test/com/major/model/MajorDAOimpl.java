package test.com.major.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.dbinfo.DB_oracle;
import test.com.dept.model.DeptVO;

public class MajorDAOimpl implements MajorDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MajorDAOimpl() {
		try {
			Class.forName(DB_oracle.DRIVER_NAME);
			System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MajorVO vo) {
		System.out.println("insert()....");
		System.out.println(vo);

		int flag = 0;
		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_MAJOR_INSERT);
			pstmt.setString(1, vo.getMajor_id());
			pstmt.setString(2, vo.getMajor_title());
			pstmt.setInt(3, vo.getMin_score());
			pstmt.setInt(4, vo.getMax_score());

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
	public List<MajorVO> selectAll() {
		System.out.println("selectAll()....");

		List<MajorVO> vos = new ArrayList<MajorVO>();

		try {
			conn = DriverManager.getConnection(DB_oracle.URL, DB_oracle.USER, DB_oracle.PASSWORD);
			System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(DB_oracle.SQL_MAJOR_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MajorVO vo = new MajorVO();
				vo.setMajor_id(rs.getString("major_id"));
				vo.setMajor_title(rs.getString("major_title"));
				vo.setMin_score(rs.getInt("min_score"));
				vo.setMax_score(rs.getInt("max_score"));
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

}
