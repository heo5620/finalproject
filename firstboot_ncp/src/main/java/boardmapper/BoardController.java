package boardmapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	//boardlist 게시물 리스트 보여주기
	//boardwrite 글쓰기
	// "/" -> start.jsp
	
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	//메인
	@RequestMapping("/")
	String start() {
		return "board/start";
	}
	
	//게시물 리스트 화면 보여주기
	//번호를 클릭하면 그에 맞는 게시물 리스트가 나온다.
	@RequestMapping("/boardlist")
	ModelAndView boardlist(@RequestParam(value = "pagenum", required=false, defaultValue = "1") int pagenum) {
		int pagecount =3;
		int start = (pagenum - 1) * pagecount; //limit 시작
		int limit[] = {start,pagecount};
		
		int totalboard = service.getTotalBoard();
		List<BoardDTO> boardlist = service.getPagingBoardList(limit);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard",totalboard);
		mv.addObject("boardlist", boardlist);
		mv.setViewName("board/list");
		return mv;
	}
	
	//게시물 상세 정보 보여주기
	@RequestMapping("/boarddetail")
	ModelAndView boarddetail(int seq) {
		BoardDTO dto = service.updateViewCountAndGetDetail(seq);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("board/detail");
		return mv;
	}
	
	
	//boardform 보여주기 (글쓰기 화면)
	@GetMapping("/boardwrite")
	String writeform() {
		return "board/writeform";
	}
	
	//글 등록
	@PostMapping("/boardwrite")
	ModelAndView writeprocess(BoardDTO dto){//title,contents,writer,pw
		int insertrow = service.registerBoard(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertrow", insertrow);
		mv.setViewName("board/start");
		return mv;
	}
	
	//글 삭제
	@RequestMapping("/boarddelete")
	String boarddelete(int seq) {
		service.deleteBoard(seq);
		return "redirect:/boardlist";
	}
	
	//글 수정
	@RequestMapping("/boardupdate")
	String boardupdate(BoardDTO dto) {
		service.updateBoard(dto);
		return "redirect:/boardlist"; //자동으로 /boardlist 메소드 호출
	}
	
	//게시물 검색
	@RequestMapping("/boardsearchlist")
	ModelAndView boardsearchlist(@RequestParam(value = "pagenum", required=false, defaultValue = "1") int pagenum, 
			@RequestParam String item, @RequestParam String searchword) {
		HashMap map =  new HashMap<>();		
		
		int pagecount =3;
		int start = (pagenum - 1) * pagecount; //limit 시작
		int limit[] = {start,pagecount};
		
		if(item.equals("all")) { //검색 항목이 '모두'일때
			map.put("colname", null);
		}else { //그외 검색 항목일때
			map.put("colname", item);
		}
		map.put("colvalue", "%"+searchword+"%");
		map.put("limit", limit);
		
		int totalSearchBoard = service.getSearchBoardCount(map);
		List<BoardDTO> boardsearchlist = service.searchBoard(map);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardsearchlist", boardsearchlist);
		mv.addObject("totalSearchBoard", totalSearchBoard);
		mv.setViewName("board/searchlist");
		return mv;
	}
	
	
}
