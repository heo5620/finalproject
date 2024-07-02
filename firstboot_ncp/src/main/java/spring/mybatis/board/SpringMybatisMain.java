package spring.mybatis.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/service/spring-mybatis.xml");
		
		//memberServiceImpl 객체 생성하여 service 저장
		MemberService service = factory.getBean("memberServiceImpl", MemberService.class);
		
		List<MemberDTO> list = service.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
		
		int totalCount = service.memberCount();
		int membersPerPage = 5;
		int totalPage = 0;
		if (totalCount%membersPerPage == 0) {
			totalPage = totalCount / 5;
		}else {
			totalPage = (totalCount / 5)+1;
		}
		
		for(int i=1; i<=totalPage; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("페이지 중 선택 가능합니다.");
	}

}
