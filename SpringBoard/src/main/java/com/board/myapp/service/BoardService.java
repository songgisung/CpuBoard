package com.board.myapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.myapp.vo.Board;

public interface BoardService {
	
		//board list
		public List<Board> getContentList(Map<String, Object> paramMap)throws Exception;
		//board detail
		public Board getContentView(Map<String, Object> paramMap)throws Exception;
		//board Insert
		public int setContentInsert(Map<String, Object> paramMap)throws Exception;
		//create
		public int create(Map<String, Object> paramMap,MultipartHttpServletRequest mRequest)throws Exception;
		//board update
		public int update(Map<String, Object> paramMap,MultipartHttpServletRequest mRequest)throws Exception;
		//board delete
		public int delete(Map<String, Object> paramMap)throws Exception;
		//file upload
		public boolean fileUpload(Map<String, Object> paramMap, MultipartHttpServletRequest mRequest)throws Exception;
		//board Get Count
		public int getContentCnt(Map<String, Object> paramMap) throws Exception;
		//==================================================
		//board get Search
		public List<Board> getSearch(Map<String, Object> paramMap)throws Exception;
		
	
}
