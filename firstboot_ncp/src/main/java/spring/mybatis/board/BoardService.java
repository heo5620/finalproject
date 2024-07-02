package spring.mybatis.board;

import java.util.List;

public interface BoardService {
	int registerBoard(BoardDTO dto); //게시글 등록
	int getTotalBoard(); //게시물 총 개수
	List<BoardDTO> getPagingBoardList(int[] limit); //게시물 페이징 처리
	BoardDTO updateViewCountAndGetDetail(int seq); //게시물 조회수 증가 및 상세 정보
	void updateBoard(BoardDTO dto); //게시물 수정
	void deleteBoard(int seq); //게시물 삭제
}
