package test.com.d_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepDAOimpl implements DepDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DepDAOimpl() {
		try {
			Class.forName(DepDB_oracle.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<DepVO> selectAll() {
		List<DepVO> vos = new ArrayList<DepVO>();
		try {
			conn = DriverManager.getConnection(DepDB_oracle.URL,DepDB_oracle.USER,DepDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(DepDB_oracle.SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DepVO vo = new DepVO();
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getInt("manager_id"));
				vo.setLocation_id(rs.getInt("location_id"));
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
	public List<Integer> selectManagerID() {
		List<Integer> mana_ids = new ArrayList<Integer>();
		try {
			conn = DriverManager.getConnection(DepDB_oracle.URL,DepDB_oracle.USER,DepDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(DepDB_oracle.SQL_MAN_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {mana_ids.add(rs.getInt("manager_id"));}
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
		
		return mana_ids;
	}

	@Override
	public List<Integer> selectLocationID() {
		List<Integer> loc_ids = new ArrayList<Integer>();
		try {
			conn = DriverManager.getConnection(DepDB_oracle.URL,DepDB_oracle.USER,DepDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(DepDB_oracle.SQL_LOC_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {loc_ids.add(rs.getInt("location_id"));}
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
		
		return loc_ids;
	}

	@Override
	public int insert(DepVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(DepDB_oracle.URL,DepDB_oracle.USER,DepDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(DepDB_oracle.SQL_INSERT);
			pstmt.setString(1, vo.getDepartment_name());
			pstmt.setInt(2, vo.getDepartment_id());
			pstmt.setInt(3, vo.getLocation_id());
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
	public int delete(DepVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(DepDB_oracle.URL,DepDB_oracle.USER,DepDB_oracle.PASSWORD);
			pstmt = conn.prepareStatement(DepDB_oracle.SQL_DELETE);
			pstmt.setInt(1, vo.getDepartment_id());
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
