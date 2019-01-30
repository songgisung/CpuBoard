package com.board.myapp.dao;

import java.util.List;
import java.util.Map;

import com.board.myapp.vo.Board;

public interface BoardDao {
	
	    //board list
	    List<Board> getContentList(Map<String, Object> paramMap)throws Exception;
	    //board detail
	    Board getContentView(Map<String, Object> paramMap)throws Exception;
	    //Board insert
	    int setContentInsert(Map<String, Object> paramMap)throws Exception;
	    //Board create
	    int create(Map<String, Object> paramMap)throws Exception;
	    //board update
	    int update(Map<String, Object> paramMap)throws Exception;
	    //board delete
	    int delete(Map<String, Object> paramMap)throws Exception;
	    //board Count
	    int getContentCnt(Map<String, Object> paramMap)throws Exception;
	    //board search
	    List<Board> getSearch(Map<String, Object> paramMap)throws Exception;
}
