package test.com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDAOimpl implements studentDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public studentDAOimpl() {
		try {
			Class.forName(studentDB_oracle.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<studentVO> studentAll() {
		List<studentVO> vos = new ArrayList<studentVO>();
		
		try {
			conn = DriverManager.getConnection(studentDB_oracle.URL,studentDB_oracle.USER,studentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(studentDB_oracle.SQL_STU);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				studentVO vo = new studentVO();
				vo.setStudent_id(rs.getInt("student_id"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setMajor_id(rs.getInt("major_id"));
				vo.setStudent_credit(rs.getInt("student_credit"));
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
	public int insert(studentVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(studentDB_oracle.URL,studentDB_oracle.USER,studentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(studentDB_oracle.SQL_INSERT);
			pstmt.setString(1, vo.getStudent_name());
			pstmt.setInt(2, vo.getDepartment_id());
			pstmt.setInt(3, vo.getMajor_id());
			pstmt.setInt(4, vo.getStudent_credit());
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
	
	@Override
	public int delete(studentVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(studentDB_oracle.URL,studentDB_oracle.USER,studentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(studentDB_oracle.SQL_DELETE);
			pstmt.setInt(1, vo.getStudent_id());
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
	
	@Override
	public List<Integer> selectDeptID() {
		List<Integer> dept_ids = new ArrayList<Integer>();
		
		try {
			conn = DriverManager.getConnection(studentDB_oracle.URL,studentDB_oracle.USER,studentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(studentDB_oracle.SQL_DEPT_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dept_ids.add(rs.getInt("department_id"));
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
		
		return dept_ids;
	}
	
	@Override
	public List<Integer> selectMajorID() {
		List<Integer> dept_ids = new ArrayList<Integer>();
		
		try {
			conn = DriverManager.getConnection(studentDB_oracle.URL,studentDB_oracle.USER,studentDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(studentDB_oracle.SQL_MAJOR_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dept_ids.add(rs.getInt("major_id"));
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
		
		return dept_ids;
	}

}
