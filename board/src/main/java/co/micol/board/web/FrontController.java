	package co.micol.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.command.Command;
import co.micol.board.command.HomeCommand;
import co.micol.board.command.MemberJoin;
import co.micol.board.command.MemberJoinForm;
import co.micol.board.command.MemberLogin;
import co.micol.board.command.MemberLoginForm;
import co.micol.board.command.MemberLogout;
import co.micol.board.command.MemberMyInfo;

import co.micol.board.command.MemberSelectList;
import co.micol.board.command.NoticeDelete;
import co.micol.board.command.NoticeForm;
import co.micol.board.command.NoticeInsert;
import co.micol.board.command.NoticeList;
import co.micol.board.command.NoticeSelect;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		//수해할 command를 넣어두는 곳
		map.put("/home.do", new HomeCommand());	//홈
		map.put("/noticeList.do", new NoticeList());	//공지사항 목록
		map.put("/noticeSelect.do", new NoticeSelect());
		map.put("/noticeForm.do", new NoticeForm());
		map.put("/noticeInsert.do", new NoticeInsert());		//게시글 저장
		map.put("/noticeDelete.do", new NoticeDelete());		//게시글 저장
		
		
		
		map.put("/memberSelectList.do", new MemberSelectList());	//멤버목록
		map.put("/memberLoginForm.do", new MemberLoginForm());	//로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin());	//실제 로그인 처리 과정 
		map.put("/memberLogout.do", new MemberLogout());	//실제 로그인 처리 과정 
		map.put("/memberJoinForm.do", new MemberJoinForm());	//회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리 
		map.put("/memberMyInfoForm.do", new MemberMyInfo());//나의 정보 폼 호출 
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 요청을 분석하고, 수행할 command를 찾아 실행하고 결과를 보여줄 페이지를 선택한다.
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath :"+contextPath);
		
		String page = uri.substring(contextPath.length());
		
		System.out.println("page :"+page);
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		System.out.println("viewPage:"+viewPage);
		
		if(!viewPage.endsWith(".do")) {	//command에 return 값이 파일 주소가 아니라 다시 컨트롤러를 돌리게끔 있는 경우가 있을수 있다.  insert를 사용할 시에 등록이 안될 경우 다시 등록을 해주기 위해 그 리스트.do로 보내주는 역활 
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
