package board.controll;

import java.io.File;
import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import board.vo.Board;


public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    private static final String UPLOAD_DIRECTORY = "upload";
    private String uploadPath = "/Users/gisungsong/Desktop/" +  UPLOAD_DIRECTORY;
    private String currentPage = null;
  
    
    
    private static final int Size_min   = 1024 * 1024 * 60;  // 3MB
    
  
    protected Board doInsertPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    	Board vo = new Board();
 	    //System.out.printf("file pat : " + uploadPath);
 	    int maxSize = 1024 * 1024 * 10; // 한번에 올릴 수 있는 파일 용량 : 10M로 제한
 	     
 	    System.out.println("insert Upload Start");
 	    
 	     
 	    //String fileName1 = ""; // 중복처리된 이름
 	    //String originalName1 = ""; // 중복 처리전 실제 원본 이름
 	    long fileSize = 0; // 파일 사이즈
 	   // String fileType = ""; // 파일 타입
 	    //String fileName="";
 	    MultipartRequest multi = null;
 	     
 	    try{
 	     
 	    	System.out.println("start");
 	        multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
 	             
	        vo.setName(multi.getParameter("name"));
	        vo.setPass(multi.getParameter("password"));
	        vo.setSubject(multi.getParameter("subject"));
	        vo.setContent(multi.getParameter("content"));
	        vo.setEnterprise(multi.getParameter("enterprise"));
	        vo.setCpuName(multi.getParameter("cpuName"));
	        vo.setSocket(multi.getParameter("socket"));
	        vo.setSpeed(multi.getParameter("speed"));
	        vo.setCore(Integer.parseInt(multi.getParameter("core")));
	        vo.setThread(Integer.parseInt(multi.getParameter("thread")));
	        vo.setGraphis(multi.getParameter("graphis"));
	        vo.setFilePath(uploadPath);
	        
	        currentPage =  multi.getParameter("page");

 	        // 전송한 전체 파일이름들을 가져옴
 	        Enumeration files = multi.getFileNames();
 	        
 	       String [] fileName = new String[20];
 	       int fileCount = 0;
 	       
 	       while(files.hasMoreElements()){
	            // form 태그에서 <input type="file" name="여기에 지정한 이름" />을 가져온다.
	            String file1 = (String)files.nextElement(); // 파일 input에 지정한 이름을 가져옴
	            // 그에 해당하는 실재 파일 이름을 가져옴
	            String originalName = multi.getOriginalFileName(file1);
	            //fileName = (String)originalName1;
	            // 파일명이 중복될 경우 중복 정책에 의해 뒤에 1,2,3 처럼 붙어 unique하게 파일명을 생성하는데
	            // 이때 생성된 이름을 filesystemName이라 하여 그 이름 정보를 가져온다.(중복에 대한 처리)
	            String fileName1 = multi.getFilesystemName(file1);
	            fileName[fileCount] = (String)fileName1;
	            // 파일 타입 정보를 가져옴
	            String fileType = multi.getContentType(file1);
	            // input file name에 해당하는 실재 파일을 가져옴
	            File file = multi.getFile(file1);
	            // 그 파일 객체의 크기를 알아냄
	            fileSize = file.length();
		        fileCount++;
	        }
 	        
 	       	for(int i = 0; i <fileCount;i++) {
 	       	vo.setFileName(i,fileName[(fileCount -1)-i]);
 	       	}
 	        
 
 	        
 	    }catch(Exception e){
 	        e.printStackTrace();
 	    }
 	    
 	    //========
        System.out.println(vo.getName());
        System.out.println(vo.getPass());
        System.out.println(vo.getSubject());
        System.out.println(vo.getContent());
        System.out.println(vo.getEnterprise());
        System.out.println(vo.getCpuName());
        System.out.println(vo.getSocket());
        System.out.println(vo.getSpeed());
        System.out.println(vo.getCore());
        System.out.println(vo.getThread());
        System.out.println(vo.getGraphis());
        System.out.println(vo.getFilePath());
        System.out.println(vo.getFileName(0));
        System.out.println(vo.getFileName(1));
        //=====
	    
	    System.out.println("insert Upload end");
	    return vo;
     }

    
    //========================================================================
    protected Board doUpdatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	Board vo = new Board();
    	System.out.println("upload start");

	    System.out.printf("file pat : " + uploadPath);
	    int maxSize = 1024 * 1024 * 10; // 한번에 올릴 수 있는 파일 용량 : 10M로 제한
	    
	   
	 
	    long fileSize = 0; // 파일 사이즈

	   
	     
	    MultipartRequest multi = null;
	     
	    try{
	     
	        multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
	        
	        currentPage =  multi.getParameter("page");
	        
	        vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
	        vo.setPass(multi.getParameter("password"));
	        vo.setSubject(multi.getParameter("subject"));
	        vo.setContent(multi.getParameter("content"));
	        vo.setEnterprise(multi.getParameter("enterprise"));
	        vo.setCpuName(multi.getParameter("cpuName"));
	        vo.setSocket(multi.getParameter("socket"));
	        vo.setSpeed(multi.getParameter("speed"));
	        vo.setCore(Integer.parseInt(multi.getParameter("core")));
	        vo.setThread(Integer.parseInt(multi.getParameter("thread")));
	        vo.setGraphis(multi.getParameter("graphic"));
	        vo.setFilePath(uploadPath);
	        	        
	        // 전송한 전체 파일이름들을 가져옴
	        Enumeration files = multi.getFileNames();
	  
	        String [] fileName = new String[20];
	 	     int fileCount = 0;
	        
	        
 	       while(files.hasMoreElements()){
	            // form 태그에서 <input type="file" name="여기에 지정한 이름" />을 가져온다.
	            String file1 = (String)files.nextElement(); // 파일 input에 지정한 이름을 가져옴
	            // 그에 해당하는 실재 파일 이름을 가져옴
	            String originalName = multi.getOriginalFileName(file1);
	            //fileName = (String)originalName1;
	            // 파일명이 중복될 경우 중복 정책에 의해 뒤에 1,2,3 처럼 붙어 unique하게 파일명을 생성하는데
	            // 이때 생성된 이름을 filesystemName이라 하여 그 이름 정보를 가져온다.(중복에 대한 처리)
	            String fileName1 = multi.getFilesystemName(file1);
	            fileName[fileCount] = (String)fileName1;
	            // 파일 타입 정보를 가져옴
	            String fileType = multi.getContentType(file1);
	            // input file name에 해당하는 실재 파일을 가져옴
	            File file = multi.getFile(file1);
	            // 그 파일 객체의 크기를 알아냄
	            fileSize = file.length();
		        fileCount++;
	        }
 	       
 	       for(int i = 0; i <fileCount;i++) {
 	       	vo.setFileName(i,fileName[(fileCount -1)-i]);
 	       	}
 	      
	    }catch(Exception e){
	        e.printStackTrace();
	    }   

	    
	    System.out.println("upload end");
	   return vo;
	    
    }
    
    public String getCurrentPage() {
    	return currentPage;
    }
	
}
