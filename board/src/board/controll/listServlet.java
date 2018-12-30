package board.controll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.Board;
import board.vo.BoardList;
import board.service.BoardService;


@WebServlet("/list.do")
public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
    public listServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temp =  request.getParameter("page");
		int currentPage = 1;
		if(temp != null) {
			currentPage =  Integer.parseInt(temp);
		}
		int pageSize = 10;
		
		BoardService board = BoardService.getInstance();
		
		int totalCount = board.getCount();
		
		//페이지 목록을 위한 변수 값들 계산하여 멤버 변수에 저장
		BoardList plist = new BoardList(currentPage,pageSize,totalCount);
		
		ArrayList<Board> list = board.getList(currentPage, pageSize);
		//int cnt = board.getCount();
		
		request.setAttribute("list", list);
		//==============================================
		request.setAttribute("plist", plist);
		
		//데이터 출력 페이지
		RequestDispatcher dispathcher = request.getRequestDispatcher("/board/listView.jsp");
		dispathcher.forward(request, response);
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		
		
	}

}
