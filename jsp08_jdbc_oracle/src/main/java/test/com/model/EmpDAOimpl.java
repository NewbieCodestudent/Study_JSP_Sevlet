package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOimpl implements EmpDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public EmpDAOimpl() {
		try {
			Class.forName(EmpDB_oracle.DRIVER_NAME);
			//System.out.println("Driver Successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<EmpVO> selectAll() {
		//System.out.println("selectAll()....");
		
		List<EmpVO> vos = new ArrayList<EmpVO>();
		
		try {
			conn = DriverManager.getConnection(
					EmpDB_oracle.URL,
					EmpDB_oracle.USER,
					EmpDB_oracle.PASSWORD);
			//System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(
					EmpDB_oracle.SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setDepartment_id(rs.getString("department_id"));
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
	public List<Integer> selectDeptID() {
		//System.out.println("selectDeptID()....");
		List<Integer> dept_ids = new ArrayList<Integer>();
		
		try {
			conn = DriverManager.getConnection(
					EmpDB_oracle.URL,
					EmpDB_oracle.USER,
					EmpDB_oracle.PASSWORD);
			//System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(
					EmpDB_oracle.SQL_DEPT_ID);
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
	public List<String> selectJobID() {
		//System.out.println("selectDeptID()....");
		List<String> job_ids = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(
					EmpDB_oracle.URL,
					EmpDB_oracle.USER,
					EmpDB_oracle.PASSWORD);
			//System.out.println("conn Successed...");
			pstmt = conn.prepareStatement(
					EmpDB_oracle.SQL_JOB_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				job_ids.add(rs.getString("job_id"));
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
		
		return job_ids;
	}

	@Override
	public int insert(EmpVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(EmpDB_oracle.URL,EmpDB_oracle.USER,EmpDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(EmpDB_oracle.SQL_INSERT);
			pstmt.setString(1, vo.getFirst_name());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setInt(3, vo.getSalary());
			pstmt.setString(4, vo.getJob_id());
			pstmt.setString(5, vo.getDepartment_id());
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
	public List<EmpVO> selectAll_view() {
		List<EmpVO> vos = new ArrayList<EmpVO>();
		try {
			conn = DriverManager.getConnection(EmpDB_oracle.URL,EmpDB_oracle.USER,EmpDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(EmpDB_oracle.SQL_SELECT_ALL_VIEW);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmp_id(rs.getInt("emp_id"));
				vo.setEmp_name(rs.getString("emp_name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDept_name(rs.getString("dept_name"));
				vo.setJob_title(rs.getString("job_title"));
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
	public List<EmpVO> selectAll_join() {
		List<EmpVO> vos = new ArrayList<EmpVO>();
		try {
			conn = DriverManager.getConnection(EmpDB_oracle.URL,EmpDB_oracle.USER,EmpDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(EmpDB_oracle.SQL_SELECT_ALL_JOIN);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmp_id(rs.getInt("emp_id"));
				vo.setEmp_name(rs.getString("emp_name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDept_name(rs.getString("dept_name"));
				vo.setJob_title(rs.getString("job_title"));
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
