package co.micol.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberSelectList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse reponse) {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list =  new ArrayList<MemberVO>();	//자기자신을 못만들어서 하위를 만들어줌 
		list = dao.memberSelectList();
		
		request.setAttribute("members", list);	//넘어온 값을 보여줄 페이지에 전달하기 위해
		
		return "member/memberSelectList";
	}

}
