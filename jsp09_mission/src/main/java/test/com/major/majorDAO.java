package test.com.major;

import java.util.List;

public interface majorDAO {
	
	public List<majorVO> majorAll();
	
	public int insert(majorVO vo);
	
}
