package test.com.board.model;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	public abstract int insert(BoardVO vo);

	public abstract int update(BoardVO vo);

	public abstract int delete(BoardVO vo);

	public abstract BoardVO searchOne(BoardVO vo);

	public abstract List<BoardVO> selectAll();

	public abstract List<BoardVO> searchList(String searchkey, String searchWord);
	
	public abstract Map<Integer, BoardVO> test();
	
}