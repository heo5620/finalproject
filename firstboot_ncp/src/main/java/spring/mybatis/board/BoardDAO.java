package spring.mybatis.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//데이터베이스와 상호작용
@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession session;
	
	int insertBoard(BoardDTO dto) {
		return session.insert("insertBoard", dto);
	}
	
	//게시물 총 개수 세기
	int getTotalCount() {
		return session.selectOne("totalCount");
	}
	
	//게시물 페이징 처리
	List<BoardDTO> getPagingBoardList (int[] limit){
		return session.selectList("boardPagingList", limit);
	}
	
	//조회수 증가
	int updateViewCount(int seq) {
		return session.update("updateViewCount",seq);
	}
	
	//게시물 한개 조회
	BoardDTO getDetail(int seq) {
		BoardDTO dto = session.selectOne("getDetail",seq);
		return dto;
	}
	
	//게시물 수정
	int updateBoard(BoardDTO dto) {
		return session.update("updateBoard",dto);
	}
	
	//게시물 삭제
	int deleteBoard(int seq) {
		return session.delete("deleteBoard",seq);
	}
}
