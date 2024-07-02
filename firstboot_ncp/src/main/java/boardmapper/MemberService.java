package boardmapper;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	List<MemberDTO> memberList(); //회원리스트조회
	MemberDTO oneMember(String id); //해당id회원조회
	int memberCount(); //전체회원수조회
	String registerMember(MemberDTO dto); //회원가입(dto id 조회(selelct)해서 있으면 가입 불가, 없으면 insert)
	String modifyMember(MemberDTO dto); //회원정보수정
	String deleteMember(String id); //회원탈퇴
	List<MemberDTO> memberPagingList(int[] limit);
	List<MemberDTO> searchMemberList(int[] pw_array);//페이징 처리 리스트
	List<MemberDTO> searchMemberList2(HashMap map);
	List<MemberDTO> searchMemberList3(MemberDTO dto);
	List<MemberDTO> searchMemberList4(MemberDTO dto);
}
