package test.com.major;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.department.departmentDB_oracle;
import test.com.department.departmentVO;

public class majorDAOimpl implements majorDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public majorDAOimpl() {
		try {
			Class.forName(majorDB_oracle.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<majorVO> majorAll() {
		List<majorVO> vos = new ArrayList<majorVO>();
		
		try {
			conn = DriverManager.getConnection(majorDB_oracle.URL,majorDB_oracle.USER,majorDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(majorDB_oracle.SQL_MAJ);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				majorVO vo = new majorVO();
				vo.setMajor_id(rs.getInt("major_id"));
				vo.setMajor_name(rs.getString("major_name"));
				vo.setMin_credit(rs.getInt("min_credit"));
				vo.setMax_credit(rs.getInt("max_credit"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	public int insert(majorVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(majorDB_oracle.URL,majorDB_oracle.USER,majorDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(majorDB_oracle.SQL_INSERT);
			pstmt.setString(1, vo.getMajor_name());
			pstmt.setInt(2, vo.getMin_credit());
			pstmt.setInt(3, vo.getMax_credit());
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

}
