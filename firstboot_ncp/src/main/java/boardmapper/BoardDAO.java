package boardmapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//데이터베이스와 상호작용
@Repository
@Mapper
public interface BoardDAO {
	
	int insertBoard(BoardDTO dto);
	
	//게시물 총 개수 세기
	int totalCount();
	
	//게시물 페이징 처리
	List<BoardDTO> PagingBoardList (int[] limit);
	
	//조회수 증가
	int updateViewCount(int seq);
	
	//게시물 한개 조회
	BoardDTO getDetail(int seq);
	
	//게시물 수정
	int updateBoard(BoardDTO dto);
	
	//게시물 삭제
	int deleteBoard(int seq);
	
	//게시물 검색
	List<BoardDTO> searchBoard(HashMap map);
	
	int searchBoardCount(HashMap map);
}
