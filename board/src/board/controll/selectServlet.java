package board.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.Board;
import board.service.BoardService;

@WebServlet("/select.do")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("select.do 접속");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String exec = request.getParameter("exec");
		System.out.println(exec);
		if(exec == null) exec="detail";
		//현재 페이지 파라메터 저
		System.out.println(exec);
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		//idx 값으로 검
		BoardService board = BoardService.getInstance();
		if(exec.equals("detail")) {
			board.readCount(idx); //글 상세 보기 조회수 증가
			
			//읽은 idx 쿠기에 저장
			Cookie c =  new Cookie("idx" + idx, String.valueOf(idx));
			c.setMaxAge(24*60*60);
			response.addCookie(c);
			
			
			//board 테이블idx 컬럼의댓글리스트
//			CommentService comment =  CommentService.getInstance();
//			ArrayList<Comment> clist = commet.getList(idx);
//			request.setAttribute("clist", clist);
		}
		System.out.println(idx);
		Board vo = board.getSelectOne(idx);
		
		String []image = new String[2];
		image[0] = vo.getFileName(0);
		image[1] = vo.getFileName(1);
		System.out.println(vo.getFileName(0));
		System.out.println(vo.getFileName(1));
		
		request.setAttribute("image", image);
		request.setAttribute("rn", "\n");
		request.setAttribute("vo", vo);
		request.setAttribute("page", currentPage);
		
		//
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/"+exec+"View.jsp");
		System.out.println("/board/"+exec+"View.jsp");
		dispatcher.forward(request, response);
			
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
