package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberMyInfo implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
//		회원 정보 가져오기
		
		MemberService memberDao= new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		
		vo = memberDao.memberOneSelect(id);
		
		request.setAttribute("members", vo);
		
		return "member/MemberMyInfoForm";
	}

}
