package spring.mybatis.board;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {
	public static void main(String args[]) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); //MyBatis의 설정을 로드하고 데이터베이스 연결을 설정할 수 있는 인스턴스 생성
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/service/mybatis-config.xml")); //mybatis-config.xml 파일에서 설정을 로드하여 데이터베이스 연결과 MyBatis의 동작 방식을 지정..
		
		SqlSession session = factory.openSession(true); //DML 실행 취소 기회 부여x. 자동 commit
		
		MemberDAO dao = new MemberDAO();
		//dao.setSession(session); //main에서 session 생성해서 dao로 넘기기.
		
		MemberServiceImpl service = new MemberServiceImpl();
		//service.setDao(dao); //위에서 만들어진 dao 넘기기
		
		//서비스 호출
		
		/*
		//전체 회원 정보
		System.out.println("====전체 회원 조회 결과====");
		List<MemberDTO> list = service.memberList();
		for(MemberDTO listdto : list) {
			System.out.println(listdto);
		}
		
		//1명 회원 정보
		System.out.println("=====회원 1명 조회 결과=====");
		MemberDTO dto = service.oneMember("mybatis1");
		System.out.println(dto);
		
		//전체 회원 수
		System.out.println("=====전체 회원 수=====");
		int membercount = service.memberCount();
		System.out.println(membercount);
		
		//회원 가입
		System.out.println("=====회원 가입 결과=====");
		MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis4");
		insertdto.setName("김냥냥");
		insertdto.setPw(1212);
		insertdto.setPhone("010-0404-0405");
		insertdto.setEmail("nanalee@gmail.com");
		
		String insertresult = service.registerMember(insertdto);
		System.out.println(insertresult);
		
		//회원 정보 수정
		System.out.println("=====회원 정보 수정 결과=====");
		MemberDTO updatedto = new MemberDTO();
		updatedto.setId("mybatis4");
		updatedto.setPw(3334);
		updatedto.setEmail("nanparkkim@gmail.com");
		
		String updateresult = service.modifyMember(updatedto);
		System.out.println(updateresult);
		
		
		//회원 탈퇴
		System.out.println("=====회원 탈퇴 결과=====");
		String deleteresult = service.deleteMember("mybatis4");
		System.out.println(deleteresult);
		*/
		
		//페이징 처리 리스트
		/*int page = 1; //현재 사용자가 선택한 페이지 번호
		int membercount = 5; //한 페이지에 보여줄 멤버 수
		
		int start = (page - 1) * membercount;
		int[] limit = {start,membercount};
		
		List<MemberDTO> list = service.memberPagingList(limit);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
		*/
		
		//암호 검색
		/*int[] pw_array = {1111,2222,3333,4444,5555};
		
		List<MemberDTO> list2 = service.searchMemberList(pw_array);
		for(MemberDTO dto : list2) {
			System.out.println(dto);
		}*/
		
		//검색 리스트 - 2개 파라미터(컬럼명, 값)
		//e.g. name like '%길%'
		//HashMap 사용
		/*
		HashMap<String, String> map = new HashMap<>();
		map.put("colname", "name"); //검색할 column
		map.put("colvalue", "%길%"); //검색값
		List<MemberDTO> list3 = service.searchMemberList2(map);
		for(MemberDTO dto : list3) {
			System.out.println(dto);
		}
		*/
		
		/*
		MemberDTO dto = new MemberDTO();
		//dto.setName("%길%");
		List<MemberDTO> list4 = service.searchMemberList3(dto);
		for(MemberDTO dto2 : list4) {
			System.out.println(dto2);
		}*/
		
		/*
		MemberDTO dto = new MemberDTO();
		dto.setName("길");
		dto.setId("db");
		List<MemberDTO> list5 = service.searchMemberList4(dto);
		for(MemberDTO dto5 : list5) {
			System.out.println(dto5);
		}
		*/
	}
}
