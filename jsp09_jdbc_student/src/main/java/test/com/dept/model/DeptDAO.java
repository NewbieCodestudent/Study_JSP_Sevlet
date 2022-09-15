package test.com.dept.model;

import java.util.List;

public interface DeptDAO {

	public int insert(DeptVO vo);

	public List<DeptVO> selectAll();

	public List<Integer> json_st_id();

}
