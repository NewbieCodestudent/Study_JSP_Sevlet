package test.com.model;

import java.util.List;

public interface EmpDAO {
	
	public List<EmpVO> selectAll();
	
	public List<EmpVO> selectAll_view();
	
	public List<EmpVO> selectAll_join();

	public List<Integer> selectDeptID();

	public List<String> selectJobID();
	
	public int insert(EmpVO vo);

}
