package test.com.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class departmentDAOimpl implements departmentDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public departmentDAOimpl() {
		try {
			Class.forName(departmentDB_oracle.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<departmentVO> departmentAll() {
		List<departmentVO> vos = new ArrayList<departmentVO>();
		
		try {
			conn = DriverManager.getConnection(departmentDB_oracle.URL,departmentDB_oracle.USER,departmentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(departmentDB_oracle.SQL_DEPT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				departmentVO vo = new departmentVO();
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setDepartment_number(rs.getString("department_number"));
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
	public int insert(departmentVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(departmentDB_oracle.URL,departmentDB_oracle.USER,departmentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(departmentDB_oracle.SQL_INSERT);
			pstmt.setString(1, vo.getDepartment_name());
			pstmt.setString(2, vo.getDepartment_number());
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
