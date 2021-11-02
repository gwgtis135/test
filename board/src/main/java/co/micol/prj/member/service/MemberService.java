package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {		//호출명 js파일명, 멤버셀렉트.vo
//기본 CRUD가 포함 되어야함 
	List<MemberVO> memberSelectList();	//테이블명 먼저 어떤 시퀄 쓸껀지 리스트 타입인지 씀  자바코딩을 참고해서 코딩 하도록 노력해야함
	MemberVO memberOneSelect(String id);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo);	//멤버 로그인 할때는 여러가지 방법이 있음  추가 기능 아이디 중복 체크 
	boolean isIdCheck(String id);	//id 값만 받으면 되서 굳이 vo 객체를 안받는다.  
	
	 
}
