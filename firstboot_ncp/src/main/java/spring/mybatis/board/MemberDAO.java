package spring.mybatis.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//직접 데이터가 존재하는 곳에 접근하는 객체
//데이터베이스와 상호작용
//sql-mapping.xml 6개 메소드

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession session; //db 접근해야함

	/*
	public void setSession(SqlSession session) {
		this.session = session;
	}*/
	
	//전체 회원 정보 조회
	List<MemberDTO> memberList(){
		List<MemberDTO> list = session.selectList("memberList");
		return list; //출력은 main에서
	}
	
	
	//1명 회원 조회
	MemberDTO oneMember(String id) {
		MemberDTO dto = session.selectOne("oneMember",id);
		//System.out.println(dto);
		return dto;
	}
	
	
	//모든 회원 수
	int memberCount() {
		int count = session.selectOne("memberCount");
		//System.out.println(count + "명의 회원이 있습니다.");
		return count;
	}
	
	
	//회원 등록
	int insertMember(MemberDTO dto){
		int insertrows = session.insert("insertMemberDTO", dto);
		return insertrows;
	}
	
	
	//회원 정보 업데이트
	int updateMember(MemberDTO dto) {
		return session.update("updateMember",dto);
	}
	
	//회원 삭제
	int deleteMember(String id) {
		return session.delete("deleteMember", id);
	}
	
	//페이징 처리 리스트
	List<MemberDTO> memberPagingList(int[] limit){
		return session.selectList("memberPagingList",limit);
	}
	
	//암호에 맞는 회원 검색
	List<MemberDTO> searchMemberList(int[] pw_array){
		return session.selectList("searchMemberList", pw_array);
	}
	
	//컬럼명, 값에 맞는 검색 리스트
	List<MemberDTO> searchMemberList2(HashMap map){
		return session.selectList("searchMemberList2",map);
	}
	
	//name 변수값 존재 여부에 따른 검색 리스트
	List<MemberDTO> searchMemberList3(MemberDTO dto){
		return session.selectList("searchMemberList3",dto);
	}
	
	//검색 시, %% 없을때
	List<MemberDTO> searchMemberList4(MemberDTO dto){
		return session.selectList("searchMemberList4",dto);
	}
	
}
