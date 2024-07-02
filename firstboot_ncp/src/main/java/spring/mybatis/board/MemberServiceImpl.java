package spring.mybatis.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired //meberdao bean 가져와서 주입
	MemberDAO dao;

	/*
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}*/

	//모든 회원 정보
	@Override
	public List<MemberDTO> memberList() {
		return dao.memberList();
	}

	//1명 회원 정보
	@Override
	public MemberDTO oneMember(String id) {
		return dao.oneMember(id);
	}
	
	//전체 회원 수
	@Override
	public int memberCount() {
		return dao.memberCount();
	}

	//회원 가입
	@Override
	public String registerMember(MemberDTO dto) {
		MemberDTO mybatis_dto = dao.oneMember(dto.getId()); //id를 가진 member 가져옴.
		if (mybatis_dto != null) { //(중복확인) 이미 회원이 있다면
			return "아이디 중복! 회원가입할 수 없습니다.";
		}else { //회원이 없는 경우
			dao.insertMember(dto);
			return "정상적으로 회원가입되었습니다.";
		}
	}
	
	//회원 정보 수정
	@Override
	public String modifyMember(MemberDTO dto) {
		MemberDTO mybatis_dto = dao.oneMember(dto.getId()); //id를 가진 member 가져옴.
		if (mybatis_dto == null) {
			return "수정할 회원 정보가 없습니다!";
		}else {
			dao.updateMember(dto);
			return "정상적으로 회원 정보 수정되었습니다.";
		}
	}
	
	//회원 탈퇴
	@Override
	public String deleteMember(String id) {
		MemberDTO mybatis_dto = dao.oneMember(id); //id를 가진 member 가져옴.
		if (mybatis_dto == null) {
			return "삭제할 회원 정보가 없습니다!";
		}else {
			dao.deleteMember(id);
			return "정상적으로 탈퇴 처리되었습니다.";
		}
	}

	//페이징 처리
	@Override
	public List<MemberDTO> memberPagingList(int[] limit) {
		return dao.memberPagingList(limit);
	}

	//비밀번호에 맞는 회원 리스트
	@Override
	public List<MemberDTO> searchMemberList(int[] pw_array) {
		return dao.searchMemberList(pw_array);
	}

	//검색어에 맞는 회원 찾기
	@Override
	public List<MemberDTO> searchMemberList2(HashMap map) {
		return dao.searchMemberList2(map);
	}

	@Override
	public List<MemberDTO> searchMemberList3(MemberDTO dto) {
		return dao.searchMemberList3(dto);
	}

	@Override
	public List<MemberDTO> searchMemberList4(MemberDTO dto) {
		return dao.searchMemberList4(dto);
	}

	//주어진 사람 수에 따라 몇 개의 페이지가 나오는 지
	
	
	
	

}
