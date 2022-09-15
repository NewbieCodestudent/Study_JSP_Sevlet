package test.com.d_model;

import java.util.List;

public interface DepDAO {
	
	public List<DepVO> selectAll();

	public List<Integer> selectManagerID();
	
	public List<Integer> selectLocationID();

	public int insert(DepVO vo);

	public int delete(DepVO vo);

}
