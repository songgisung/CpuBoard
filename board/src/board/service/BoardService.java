package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import board.dao.BoardDAO;
import board.db.DBConn;
import board.vo.Board;
import board.service.BoardService;

public class BoardService {
	private static BoardService service =  new BoardService();
	private BoardService() {}
	public static BoardService getInstance() {
		return service;
	}
	
	//글 개수 가져 오기
	public int getCount() {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		try {
			int cnt  = dao.getCount();
			return cnt;
		}catch (SQLException e){
			System.out.println("getCount Exception");
		}
		
		return 0;
	}
	
	//글 목록 가져오기
	public ArrayList<Board> getList(int currentPage, int pageSize){
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		int startNo = (currentPage - 1) * pageSize;
		ArrayList<Board> list = null;
		try {
			list = dao.getList(startNo, pageSize);
		}catch(SQLException e) {
			System.out.println("getList Exception");
		}
		
		DBConn.Close(con);
		return list;
	}
	
	//==================================================================
	//검색한 리스트 가져오기 getSearchList
	public ArrayList<Board> getSearchList(int currentPage, int pageSize,String searchType, String searchTemp){
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		int startNo = (currentPage - 1) * pageSize;
		ArrayList<Board> list = null;
		try {
			list = dao.getSearchList(startNo, pageSize, searchType, searchTemp);
		}catch(SQLException e) {
			System.out.println("getSearchList Exception");
		}
		
		DBConn.Close(con);
		return list;
	}
	
	
	//검색된 글 개수 가져 오기
	public int getSearchCount(String searchType, String searchTemp) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		try {
			int cnt  = dao.getSearchCount(searchType, searchTemp);
			return cnt;
		}catch (SQLException e){
			System.out.println("getCount Exception");
		}
		
		return 0;
	}
	//==================================================================
	//==================================================================
	
	//게시물 작성
	public void insert(Board vo) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		try {
			dao.insert(vo);//sql 실행 dao 객체 메소드 실
		}catch(SQLException e) {
			System.out.println("Insert Exception");
			e.printStackTrace();
		}
		DBConn.Close(con);
		
	}
	//글 조회 데이터 가져오기
	public Board getSelectOne(int idx) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		Board vo = null;
		try {
			vo = dao.getSelectOne(idx);
		}catch(SQLException e) {
			System.out.println("getSelectOne Exception");
			e.printStackTrace();
		}
		if(vo == null) {
			System.out.println("vo-> null");
		}
		DBConn.Close(con);
		return vo;
	}

	//글 조회 수 증가
	public void readCount(int idx) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		try {
			dao.readCount(idx);
		}catch(SQLException e) {
			System.out.println("readCount Exception");
			e.printStackTrace();
		}
		DBConn.Close(con);
	}
	
	//글 수정
	public void update(Board vo) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		try {
			dao.update(vo);
			System.out.println("update complete");
		}catch(SQLException e) {
			System.out.println("update Exception");
			e.printStackTrace();
		}
		DBConn.Close(con);
	}
	// 글삭제
	public void delete(int idx) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		try {
			dao.delete(idx);
		}catch(SQLException e) {
			System.out.println("update Exception");
			e.printStackTrace();
		}
		DBConn.Close(con);
	}
	
	public boolean isPassword(int idx, String password) {
		Connection con = DBConn.getMySqlConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.SetConnection(con);
		
		boolean result = false;
		
		try {
			result = dao.isPassword(idx, password);
		}catch(SQLException e) {
			System.out.println("Password check Exception");
			e.printStackTrace();
		}
		return result;
	}
}
