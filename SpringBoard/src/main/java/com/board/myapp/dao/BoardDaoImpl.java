package com.board.myapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.myapp.vo.Board;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
    private SqlSession sqlSession;
 
    public void setSqlSession(SqlSession sqlSession) throws Exception{
        this.sqlSession = sqlSession;
    }
    
    //board Get Count
    @Override
    public int getContentCnt(Map<String, Object> paramMap) throws Exception {
        return sqlSession.selectOne("selectContentCnt", paramMap);
    }
    
    @Override
    public List<Board> getSearch(Map<String, Object> paramMap) throws Exception{
    	return sqlSession.selectList("search", paramMap);
    }
    
    //board list
    @Override
    public List<Board> getContentList(Map<String, Object> paramMap) throws Exception{
        return sqlSession.selectList("selectContent", paramMap);
    }
 
    //board detail
    @Override
    public Board getContentView(Map<String, Object> paramMap) throws Exception {
        return sqlSession.selectOne("selectContentView", paramMap);
    }
    
    //board insert
    @Override
    public int setContentInsert(Map<String, Object> paramMap) throws Exception{
    	return sqlSession.selectOne("insertContent", paramMap);
    }
    
    //board create
    @Override
    public int create(Map<String, Object> paramMap) throws Exception {
    	return sqlSession.insert("boardCreate",paramMap);
    }
    //board update
    @Override
    public int update(Map<String, Object> paramMap) throws Exception {
    	return sqlSession.update("boardUpdate",paramMap);
    }
    
    //board delete
    @Override
    public int delete(Map<String, Object> paramMap) throws Exception {
    	return sqlSession.delete("boardDelete",paramMap);
    }
}
