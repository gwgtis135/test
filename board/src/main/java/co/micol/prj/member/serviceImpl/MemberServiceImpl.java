package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.comm.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {		//오버라이드 키어ㅜ드를 지우면 안됨 지우면 독릭메서드가 되어버림 

	private DataSource datasource = DataSource.getInstance();
	private Connection conn = datasource.getConnection();
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>();	//자기자신을 추상으로 만들 수 없어서 하위 객체인 어레이를 만듬 
		MemberVO vo;
		String sql = "select * from member";
		try {
			conn = datasource.getConnection();	//한번만 클로즈 되어버리면 호출이 안되서 매번 여기다가 넣어준다. 
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAuthor(rs.getString("author"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	@Override
	public MemberVO memberOneSelect(String id) {		//나의페이지에 보여줄 내정보
		MemberVO vo = null;
		String sql = "select * from member where id = ?";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n =0;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		try{
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setString(6, vo.getAuthor());
			n = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql  = "select * from member where id = ? and password = ?";
		try {
			conn = datasource.getConnection();	//한번만 클로즈 되어버리면 호출이 안되서 매번 여기다가 넣어준다. 
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;	//보에다가 담아서 보내줄꺼임 
	}

	@Override
	public boolean isIdCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void close() {
		try {
			if(rs != null )rs.close();
			if(psmt != null )psmt.close();
			if(conn != null )conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
