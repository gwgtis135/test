package co.micol.board.notice.service;

import java.util.List;
//기본적인 crud를 담고 있다. 
public interface NoticeService {
	List<NoticeVO> noticeSelectList();	//저넻목록 가져옴
	NoticeVO noticeSelect(NoticeVO vo);	//한글 읽는거  
	int noticeInsert(NoticeVO vo);		//글작성
	int noticeUpdate(NoticeVO vo);		//글수정
	int noticeDelete(NoticeVO vo);		//글삭제 
	
}
