package spring.mybatis.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public int registerBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int getTotalBoard() {
		return dao.getTotalCount();
	}

	@Override
	public List<BoardDTO> getPagingBoardList(int[] limit) {
		return dao.getPagingBoardList(limit);
	}

	@Override
	public BoardDTO updateViewCountAndGetDetail(int seq) {
		dao.updateViewCount(seq);
		return dao.getDetail(seq);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		dao.updateBoard(dto);
		
	}

	@Override
	public void deleteBoard(int seq) {
		dao.deleteBoard(seq);
	}	
	
	
}
