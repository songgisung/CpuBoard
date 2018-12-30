package board.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.Board;
import board.service.BoardService;
import board.controll.uploadServlet;


@WebServlet("/update.do")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  public updateServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/board/updateView.jsp");
		
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("수정페이지 호출");
		//응답으로 전달되는 웹페이지의 형식설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		

		//==================
		
		BoardService board = BoardService.getInstance();
		//
		
		
		Board vo = new Board();
		
		uploadServlet upload = new uploadServlet();
		
		vo = upload.doUpdatePost(request, response);
			System.out.println(vo.getIdx());
			System.out.println(vo.getPass());
		
						
		//글 비밀번호 체크
		if(board.isPassword(vo.getIdx(), vo.getPass())) {
			System.out.println("비밀번호 일치 글수정");
			board.update(vo);
			response.sendRedirect("list.do?page=" + upload.getCurrentPage());
		}else {
			out.print("<script>");
	  		out.print("alert('パスワードが違います.');");
	  		out.print("history.back();");
	  		out.print("</script>");
		}
	
	}


}
