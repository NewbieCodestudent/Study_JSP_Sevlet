package test.com.student.model;

import java.util.List;

public interface StDAO {

	public int insert(StVO vo);

	public List<StVO> selectAll();

	public List<Integer> json_dept_id();

	public List<String> json_major_id();

}
