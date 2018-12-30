package board.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.Board;
import board.service.BoardService;
import board.controll.uploadServlet;

@WebServlet("/insert.do")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/insertView.jsp");
		dispatcher.forward(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("insert Start");

		uploadServlet upload = new uploadServlet();
		
		BoardService board = BoardService.getInstance();
		//
		Board vo = new Board();
		vo = upload.doInsertPost(request, response);
		
		board.insert(vo);
		System.out.println("insert end");
		response.sendRedirect("list.do");
		
		//doGet(request, response);
	}

}
