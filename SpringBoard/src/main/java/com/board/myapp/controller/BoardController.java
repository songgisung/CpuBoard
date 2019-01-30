package com.board.myapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.myapp.service.BoardService;
import com.board.myapp.vo.BoardPage;



@Controller
public class BoardController {
	
	@Autowired
    BoardService boardService;
	
	private static final int pageSize = 10;

	 
	
//	@RequestMapping(value="/board/upload")
//	public String boardUpload(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
//		System.out.println("file upload jsp"); 
//		return "fileUpload_submit";
//	}
//    
//	@RequestMapping(value="/board/complete")
//	public String boardUploadComplete(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
//		System.out.println("file upload complete"); 
//		return "fileUpload_result";
//	}
//	 
//	@RequestMapping(value="board/fileUpload", method=RequestMethod.POST)
//	public String fileUpload(@RequestParam Map<String, Object> paramMap, Model model ,MultipartHttpServletRequest mRequest) {
//		System.out.println("file upload");
//		return "redirect:/board/complete";
//	}

	//--------------------------------------------------------------------
    //board list
    @RequestMapping(value = "/board/list")
    public String boardList(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
 
    	System.out.println("list");
    	
    	String temp = (String)paramMap.get("page");
    
    	int currentPage = 1;
    	if(temp != null) {
			currentPage =  Integer.parseInt(temp);
		}
    	System.out.println(currentPage);
    	int totalCnt = boardService.getContentCnt(paramMap);
    
    	BoardPage plist = new BoardPage(currentPage,pageSize,totalCnt);
    
        paramMap.put("start", plist.getStart());
        paramMap.put("end",  plist.getEndPage());
      
        model.addAttribute("boardList", boardService.getContentList(paramMap));
        model.addAttribute("plist", plist);
       
        return "listView";
 
    }
    
    
    //--------------------------------------------------------------------
    //board detail
    @RequestMapping(value = "/board/view")
    public String boardView(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {  	
    	
    	model.addAttribute("vo", boardService.getContentView(paramMap));
             
        System.out.println("detail");
        return "detailView";
 
    }
  
    
    //--------------------------------------------------------------------
    //board udpate
    @RequestMapping(value = "/board/updateview")
    public String boardUpdate(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
    	System.out.println("update View");	
    	model.addAttribute("vo", boardService.getContentView(paramMap));
    	return "updateView";
    }
    
    @RequestMapping(value = "/board/update")
    public String Update(@RequestParam Map<String, Object> paramMap, Model model, MultipartHttpServletRequest mRequest)throws Exception {
    	System.out.println("update");
    	content(paramMap);
    	int result = boardService.update(paramMap, mRequest);	
    	return "redirect:/board/list";
    }
    
   
    //--------------------------------------------------------------------
    //board insert
    @RequestMapping(value = "/board/insert")
    public String boardInsert(@RequestParam Map<String, Object> paramMap, Model model) {
    	System.out.println("insert");
    	return "insertView";
    }
    //Board Create
    @RequestMapping(value = "/board/create")
    public String boardCreate(@RequestParam Map<String, Object> paramMap, Model model,MultipartHttpServletRequest mRequest) throws Exception{
    	System.out.println("create");
    	content(paramMap);
    	
    	
    	int result = boardService.create(paramMap,mRequest);	
    	//test upload    	
    	return "redirect:/board/list";
    }
    
    
    //--------------------------------------------------------------------
    //board delete
    @RequestMapping(value = "/board/deleteview")
    public String boardDelete(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
    	System.out.println("deleteView");
    	model.addAttribute("vo", boardService.getContentView(paramMap));
    	return "deleteView";
    }

    @RequestMapping(value = "/board/delete")
    public String delete(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
    	System.out.println("delete");
    	content(paramMap);
    	int result = boardService.delete(paramMap);	
    	return "redirect:/board/list";
    }
    
    //--------------------------------------------------------------------
    //board search
    @RequestMapping(value = "/board/search")
    public String search(@RequestParam Map<String, Object> paramMap, Model model) throws Exception {
    	
    	System.out.println("search");
    	
    	String temp = (String)paramMap.get("page");
    	
    	int currentPage = 1;
    	if(temp != null) {
			currentPage =  Integer.parseInt(temp);
		}
    	System.out.println(currentPage);
    	int totalCnt = boardService.getContentCnt(paramMap);
    
    	BoardPage plist = new BoardPage(currentPage,pageSize,totalCnt);


        paramMap.put("start", plist.getStartPage());
        paramMap.put("end",  plist.getEndPage());
      
       
        model.addAttribute("BoardList", boardService.getSearch(paramMap));//검색
        model.addAttribute("searchplist", plist);//검색
       
        return "searchView";
    }
    
    public boolean isCheckNull(@RequestParam Map<String, Object> paramMap)throws Exception {
    		if(paramMap.get("name") == "") {
    			return false;
    		}
    		else if(paramMap.get("password") == "") {
    			return false;
    		}
    		else if(paramMap.get("subject") == "") {
    			return false;
    		}
    		else {
    			return true;
    		}
    }
 
    //date
    public void content(@RequestParam Map<String, Object> paramMap)throws Exception{
    	System.out.println(paramMap.get("name"));   
    	System.out.println(paramMap.get("password"));  
    	System.out.println(paramMap.get("subject"));  
    	System.out.println(paramMap.get("content")); 
    	System.out.println(paramMap.get("graphic"));  
    	System.out.println(paramMap.get("enterprise"));
    	System.out.println(paramMap.get("cpuname"));  
    	System.out.println(paramMap.get("core"));  
    	System.out.println(paramMap.get("thread"));  
    	System.out.println(paramMap.get("graphis"));  
    	System.out.println(paramMap.get("speed"));  
    	System.out.println(paramMap.get("filePath"));  
    	System.out.println(paramMap.get("fileName1"));  
    	System.out.println(paramMap.get("fileName2")); 
    }
   

 
}
