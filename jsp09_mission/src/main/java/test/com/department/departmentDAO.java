package test.com.department;

import java.util.List;

public interface departmentDAO {
	
	public List<departmentVO> departmentAll();
	
	public int insert(departmentVO vo);

}
