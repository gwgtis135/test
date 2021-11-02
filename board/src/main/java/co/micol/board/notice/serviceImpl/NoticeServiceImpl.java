package co.micol.board.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.comm.DataSource;
import co.micol.board.notice.service.NoticeService;
import co.micol.board.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select * from notice order by nid desc";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setnId(rs.getInt("nid"));
				vo.setName(rs.getString("name"));
				vo.setWriteDate(rs.getDate("writedate"));
				vo.setTitle(rs.getString("title"));
				vo.setHit(rs.getString("hit"));
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
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql  = "select * from notice where nid = ?";
		try {
			conn = dataSource.getConnection();
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, vo.getnId());
			rs = psmt.executeQuery();
			//레코드가 하나라서 if를 사용함 
			if(rs.next()) {
				vo = new NoticeVO();
				vo.setnId(rs.getInt("nid"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setWriteDate(rs.getDate("writedate"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setHit(rs.getString("hit"));
				
				hitUpdate(vo.getnId());		//조회수 업데이트
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close();
		}
		
		return vo;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		int n=0;
		String sql = "insert into notice values(b_seq.nextval,?,?,?,?,?,0)"; //히트수는 디폴트 0
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setDate(3, vo.getWriteDate());
			psmt.setString(4, vo.getTitle());
			psmt.setString(5, vo.getContents());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {	//제목과 내용만 수정할수 있다고 전제 
		int n =0;
		String sql = "update notice set title =?, contents =? where nid =?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContents() );
			psmt.setInt(3, vo.getnId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		int n =0;
		String sql = "delete from notice where nid =?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getnId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn !=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//finally 안해준다. 외부에서 쓰기 때문에 커넥션이 이미 만들어져있음 
	private void hitUpdate(int nid) {	//nid값이 피룡하다
		String sql = "update notice set hit = hit +1 where nid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, nid);
			psmt.executeUpdate();	//조회시 count를 증가시켜준다. 
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
				
	}
}
