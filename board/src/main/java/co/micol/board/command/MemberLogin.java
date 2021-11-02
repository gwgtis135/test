package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse reponse) {
		HttpSession session = request.getSession();
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));	//폼에서 입력값을  vo객체에 담음 
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDao.memberLogin(vo);		//dao에서 db랑 비교 해서 넣어주는 것 
		String page = null;	//돌려줄 페이지
		if(vo.getName() != null) {
			
			session.setAttribute("id", vo.getId());	//session에 값을 담아 놓는다. 
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			page = "member/memberLoginSuccess";
		}else {
			page = "member/memverLoginFail";
		}
		return page;
	}

}
