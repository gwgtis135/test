package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.notice.service.NoticeService;
import co.micol.board.notice.service.NoticeVO;
import co.micol.board.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelect implements Command {

	
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//하나의 게시글을 조회한다. 세부내용 보기 
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setnId(Integer.valueOf(request.getParameter("nid")));
		vo = noticeDao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeSelect";
	}

}
