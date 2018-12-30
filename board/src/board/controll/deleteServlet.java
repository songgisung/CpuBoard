package board.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;

@WebServlet("/delete.do")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		int idx= Integer.parseInt(request.getParameter("idx"));
		String password = request.getParameter("password");
		int currentPage = Integer.parseInt(request.getParameter("page"));
		BoardService board = BoardService.getInstance();
		
		//글 번호 체크
		//글 비밀번호 체크
		if(board.isPassword(idx, password)) {
			board.delete(idx);
			response.sendRedirect("list.do?page=" + currentPage);
		}else {
			out.print("<script>");
	  		out.print("alert('パスワードが違います.');");
	  		out.print("history.back();");
	  		out.print("</script>");
		}
		
		
		
	}

}
