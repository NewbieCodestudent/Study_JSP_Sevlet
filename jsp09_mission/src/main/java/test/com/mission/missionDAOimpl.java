package test.com.mission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class missionDAOimpl implements missionDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public missionDAOimpl() {
		try {
			Class.forName(missionDB_oracle.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<missionVO> selectAll_view() {
		List<missionVO> vos = new ArrayList<missionVO>();
		
		try {
			conn = DriverManager.getConnection(missionDB_oracle.URL,missionDB_oracle.USER,missionDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(missionDB_oracle.SQL_SELECT_ALL_VIEW);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				missionVO vo = new missionVO();
				vo.setStudent_id(rs.getInt("student_id"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setDepartment_number(rs.getString("department_number"));
				vo.setMajor_id(rs.getInt("major_id"));
				vo.setMajor_name(rs.getString("major_name"));
				vo.setMin_credit(rs.getInt("min_credit"));
				vo.setMax_credit(rs.getInt("max_credit"));
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
	public List<missionVO> selectAll_join() {
		List<missionVO> vos = new ArrayList<missionVO>();
		
		try {
			conn = DriverManager.getConnection(missionDB_oracle.URL,missionDB_oracle.USER,missionDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(missionDB_oracle.SQL_SELECT_ALL_JOIN);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				missionVO vo = new missionVO();
				vo.setStudent_id(rs.getInt("student_id"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setDepartment_number(rs.getString("department_number"));
				vo.setMajor_id(rs.getInt("major_id"));
				vo.setMajor_name(rs.getString("major_name"));
				vo.setMin_credit(rs.getInt("min_credit"));
				vo.setMax_credit(rs.getInt("max_credit"));
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
	public List<missionVO> majorAll() {
		List<missionVO> vos = new ArrayList<missionVO>();
		
		try {
			conn = DriverManager.getConnection(missionDB_oracle.URL,missionDB_oracle.USER,missionDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(missionDB_oracle.SQL_MAJ);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				missionVO vo = new missionVO();
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
	public List<missionVO> departmentAll() {
		List<missionVO> vos = new ArrayList<missionVO>();
		
		try {
			conn = DriverManager.getConnection(missionDB_oracle.URL,missionDB_oracle.USER,missionDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(missionDB_oracle.SQL_DEPT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				missionVO vo = new missionVO();
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
	public List<missionVO> studentAll() {
		List<missionVO> vos = new ArrayList<missionVO>();
		
		try {
			conn = DriverManager.getConnection(missionDB_oracle.URL,missionDB_oracle.USER,missionDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(missionDB_oracle.SQL_STU);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				missionVO vo = new missionVO();
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

}
