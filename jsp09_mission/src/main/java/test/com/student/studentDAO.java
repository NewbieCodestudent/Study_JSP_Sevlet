package test.com.student;

import java.util.List;

public interface studentDAO {
	
	public List<studentVO> studentAll();
	
	public int insert(studentVO vo);
	
	public int delete(studentVO vo);
	
	public List<Integer> selectDeptID();
	
	public List<Integer> selectMajorID();

}
