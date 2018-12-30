package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.vo.Board;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	private BoardDAO() {	}
	public static BoardDAO getInstance() {
		return boardDAO;
		
	}
	private Connection con;
	
	public void SetConnection(Connection cnn){
		this.con = cnn;
	}
	
	//=============글 비밀 번호 검사
	public boolean isPassword(int idx, String password) throws SQLException {
		String sql = "select * from cpuBoard where idx=? and password=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())return true;
		else return false;
	}
	//===========조회수 증가
	public void readCount(int idx) throws SQLException{
		String sql="update cpuBoard set readCount=readCount+1 where idx=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.execute();
	}
	
	//==============글 수정(제목, 내용, 사진 변)
	public void update(Board vo) throws SQLException {
		//String sql="update cpuBoard set subject=?,content=?,filePath=?,fileName=? where idx = ?";
		if(vo.getFileName(0) != null && vo.getFileName(1) != null) {
		String sql="update cpuBoard set subject=?,content=?,enterprise=?,cpuname=?,socket=?,speed=?,core=?,thread=?,graphis=?,filePath=?,fileName1=?,fileName2=? where idx = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getSubject());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getEnterprise());
		pstmt.setString(4, vo.getCpuName());
		pstmt.setString(5, vo.getSocket());
		pstmt.setString(6, vo.getSpeed());
		pstmt.setInt(7, vo.getCore());
		pstmt.setInt(8, vo.getThread());
		pstmt.setString(9, vo.getGraphis());
		pstmt.setString(10, vo.getFilePath());
		pstmt.setString(11, vo.getFileName(0));
		pstmt.setString(12, vo.getFileName(1));
		pstmt.setInt(13, vo.getIdx());
		pstmt.execute();
		}else if(vo.getFileName(0) == null && vo.getFileName(1) != null) {
			String sql="update cpuBoard set subject=?,content=?,enterprise=?,cpuname=?,socket=?,speed=?,core=?,thread=?,graphis=?,filePath=?,fileName2=? where idx = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getEnterprise());
			pstmt.setString(4, vo.getCpuName());
			pstmt.setString(5, vo.getSocket());
			pstmt.setString(6, vo.getSpeed());
			pstmt.setInt(7, vo.getCore());
			pstmt.setInt(8, vo.getThread());
			pstmt.setString(9, vo.getGraphis());
			pstmt.setString(10, vo.getFilePath());
			pstmt.setString(11, vo.getFileName(1));
			pstmt.setInt(12, vo.getIdx());
			pstmt.execute();
			
		}else if(vo.getFileName(0) != null && vo.getFileName(1) == null) {
			String sql="update cpuBoard set subject=?,content=?,enterprise=?,cpuname=?,socket=?,speed=?,core=?,thread=?,graphis=?,filePath=?,fileName1=? where idx = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getEnterprise());
			pstmt.setString(4, vo.getCpuName());
			pstmt.setString(5, vo.getSocket());
			pstmt.setString(6, vo.getSpeed());
			pstmt.setInt(7, vo.getCore());
			pstmt.setInt(8, vo.getThread());
			pstmt.setString(9, vo.getGraphis());
			pstmt.setString(10, vo.getFilePath());
			pstmt.setString(11, vo.getFileName(0));
			pstmt.setInt(12, vo.getIdx());
			pstmt.execute();
			
		}else {
			String sql="update cpuBoard set subject=?,content=?,enterprise=?,cpuname=?,socket=?,speed=?,core=?,thread=?,graphis=?,filePath=? where idx = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getEnterprise());
			pstmt.setString(4, vo.getCpuName());
			pstmt.setString(5, vo.getSocket());
			pstmt.setString(6, vo.getSpeed());
			pstmt.setInt(7, vo.getCore());
			pstmt.setInt(8, vo.getThread());
			pstmt.setString(9, vo.getGraphis());
			pstmt.setString(10, vo.getFilePath());
			pstmt.setInt(11, vo.getIdx());
			pstmt.execute();
		}
	} 
	
	
	//=============글삭제
	public void delete(int idx) throws SQLException{
		String sql="delete from cpuBoard where idx = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.execute();
	}
	
	//================글 작성
	public void insert(Board vo)throws SQLException{
		String sql="insert into cpuBoard(name,password,subject,content,enterprise,cpuname,socket,speed,core,thread,graphis,filePath,fileName1,fileName2)"+"value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPass());
		pstmt.setString(3, vo.getSubject());
		pstmt.setString(4, vo.getContent());
		//cpu
		pstmt.setString(5, vo.getEnterprise());
		pstmt.setString(6, vo.getCpuName());
		pstmt.setString(7, vo.getSocket());
		pstmt.setString(8, vo.getSpeed());
		pstmt.setInt(9, vo.getCore());
		pstmt.setInt(10, vo.getThread());
		pstmt.setString(11, vo.getGraphis());
		//==================================
		pstmt.setString(12, vo.getFilePath());
		pstmt.setString(13, vo.getFileName(0));
		pstmt.setString(14, vo.getFileName(1));
		//pstmt.setString(14, "null");
		pstmt.execute();
	}
	//==================전체 글의 개수
	public int getCount()throws SQLException{
		String sql = "select count(*) from cpuBoard";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int cnt =rs.getInt(1);
		
		return cnt;
 	}
	
	//==================검색된 글의 개수
	public int getSearchCount(String searchType, String searchTemp)throws SQLException{
		String sql =  "select count(*) from cpuBoard where " + searchType + " like '%"+searchTemp+"%'"; 
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int cnt =rs.getInt(1);
		
		return cnt;
 	}
	
	private Board setVo(ResultSet rs)throws SQLException {
		Board vo = new Board();
		
		vo.setIdx(rs.getInt("idx"));
		vo.setName(rs.getString("name"));
		vo.setPass(rs.getString("password"));
		vo.setSubject(rs.getString("subject"));
		vo.setContent(rs.getString("content"));
		vo.setReadCount(rs.getInt("readCount"));
		vo.setWdate(rs.getTimestamp("wdate"));
		vo.setFilePath(rs.getString("filePath"));
		vo.setFileName(0,rs.getString("fileName1"));
		vo.setFileName(1,rs.getString("fileName2"));
		//cpu
		vo.setEnterprise(rs.getString("enterprise"));
		vo.setCpuName(rs.getString("cpuName"));
		vo.setSocket(rs.getString("socket"));
		vo.setSpeed(rs.getString("speed"));
		vo.setCore(rs.getInt("core"));
		vo.setThread(rs.getInt("thread"));
		vo.setGraphis(rs.getString("graphis"));
		
		return vo;
	}
	
	//글 목록에서 검색으로 찾아서 넘겨주
	public ArrayList<Board> getSearchList(int startNo,int pageSize,String searchType, String searchTemp)throws SQLException{
		String sql =  "select * from cpuBoard where " + searchType + " like '%"+searchTemp+"%' order by idx desc limit ?,?";  
		System.out.println(sql);
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		
		//데이터 저장 개체
		ArrayList<Board> list = new ArrayList<>();
		 
		if(rs.next())
		{
			do {		
				Board vo = new Board();
				vo = setVo(rs);
//				vo.setIdx(rs.getInt("idx"));
//				vo.setName(rs.getString("name"));
//				vo.setPass(rs.getString("password"));
//				vo.setSubejct(rs.getString("subject"));
//				vo.setContent(rs.getString("content"));
//				vo.setReadCount(rs.getInt("readCount"));
//				vo.setWdate(rs.getTimestamp("wdate"));
//				vo.setFilePath(rs.getString("filePath"));
//				vo.setFileName1(rs.getString("fileName1"));
//				vo.setFileName2(rs.getString("fileName2"));				
				//=======================		
				list.add(vo);
			}while(rs.next());
		}
		
		return list;
	}
	
	//idx 컬럼으로 특정 데이터 검:결과가 한개  행(레코드)
	public Board getSelectOne(int idx)throws SQLException{
		String sql = "select * from cpuBoard where idx =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, idx);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		Board vo =  new Board();
		
	
		vo = setVo(rs);
//		vo.setIdx(rs.getInt("idx"));
//		vo.setName(rs.getString("name"));
//		vo.setPass(rs.getString("password"));
//		vo.setTitle(rs.getString("title"));
//		vo.setContent(rs.getString("content"));
//		vo.setIp(rs.getString("ip"));
//		vo.setreadCnt(rs.getInt("readCount"));
//		vo.setWdate(rs.getTimestamp("wdate"));
//		vo.setImageRoute(rs.getString("imageRoute"));
//		vo.setFileName(rs.getString("fileName"));
		return vo;
	}
	
	
	//글 목록 결과가 여러개 행
	public ArrayList<Board> getList(int startNo,int pageSize)throws SQLException{
		String sql = "select * from cpuBoard order by idx desc limit ?,?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		
		//데이터 저장 개체
		ArrayList<Board> list = new ArrayList<>();
		
		if(rs.next())
		{
			do {		
				Board vo = new Board();
				
				vo = setVo(rs);
				System.out.println(vo.getName());
//				vo.setIdx(rs.getInt("idx"));
//				vo.setName(rs.getString("name"));
//				vo.setPass(rs.getString("password"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				vo.setIp(rs.getString("ip"));
//				vo.setreadCnt(rs.getInt("readCount"));
//				vo.setWdate(rs.getTimestamp("wdate"));
//				vo.setImageRoute("imageRoute");
//				vo.setFileName("fileName");
				list.add(vo);
			}while(rs.next());
		}
		
		return list;
	}
}
