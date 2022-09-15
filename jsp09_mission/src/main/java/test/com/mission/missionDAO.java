package test.com.mission;

import java.util.List;

public interface missionDAO {
	
	public List<missionVO> selectAll_view();
	
	public List<missionVO> selectAll_join();
	
	public List<missionVO> majorAll();
	
	public List<missionVO> departmentAll();

	public List<missionVO> studentAll();

}
