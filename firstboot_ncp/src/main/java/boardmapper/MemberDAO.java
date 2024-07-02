package boardmapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//직접 데이터가 존재하는 곳에 접근하는 객체
//데이터베이스와 상호작용
//sql-mapping.xml 6개 메소드

@Repository
@Mapper
public interface MemberDAO {
	
	//전체 회원 정보 조회
	List<MemberDTO> memberList();
	
	
	//1명 회원 조회
	MemberDTO oneMember(String id);
	
	
	//모든 회원 수
	int memberCount();
	
	
	//회원 등록
	int insertMemberDTO(MemberDTO dto);
	
	
	//회원 정보 업데이트
	int updateMember(MemberDTO dto);
	
	//회원 삭제
	int deleteMember(String id);
	
	//페이징 처리 리스트
	List<MemberDTO> memberPagingList(int[] limit);
	
	//암호에 맞는 회원 검색
	List<MemberDTO> searchMemberList(int[] pw_array);
	
	//컬럼명, 값에 맞는 검색 리스트
	List<MemberDTO> searchMemberList2(HashMap map);
	
	//name 변수값 존재 여부에 따른 검색 리스트
	List<MemberDTO> searchMemberList3(MemberDTO dto);
	
	//검색 시, %% 없을때
	List<MemberDTO> searchMemberList4(MemberDTO dto);
	
}
