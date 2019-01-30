package com.board.myapp.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.myapp.dao.BoardDao;
import com.board.myapp.vo.Board;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private static final String uploadPath = "/Users/gisungsong/Desktop/upload/";
	
	@Resource(name="boardDao")
    private BoardDao boardDao;
	
	//====================================================================
	//board list
    @Override
    public List<Board> getContentList(Map<String, Object> paramMap) throws Exception{
        return boardDao.getContentList(paramMap);
    }
 
  //====================================================================
    //board detail
    @Override
    public Board getContentView(Map<String, Object> paramMap)throws Exception {
        return boardDao.getContentView(paramMap);
    }
    
    //====================================================================
    //board insert
    @Override
    public int setContentInsert(Map<String, Object> paramMap)throws Exception {
    	return boardDao.setContentInsert(paramMap);
    }
    //board Create
    @Override
    public int create(Map<String, Object> paramMap,MultipartHttpServletRequest mRequest)throws Exception{
    	
    	fileUpload(paramMap,mRequest);	
    	return boardDao.create(paramMap);
    }

    public  int check(Map<String, Object> paramMap) {
    	
    	//if(paramMap.get("password") )
    return 1;
    }
    
   
    
    //====================================================================
    //board update
    @Override
	public int update(Map<String, Object> paramMap, MultipartHttpServletRequest mRequest) throws Exception{
    	fileUpload(paramMap,mRequest);
		return boardDao.update(paramMap);
	}
    
    //====================================================================
    //board delete
    @Override
    public int delete(Map<String, Object> paramMap)throws Exception {
    	return boardDao.delete(paramMap);
    }
	
    //====================================================================
    //board Get Count
    @Override
    public int getContentCnt(Map<String, Object> paramMap) throws Exception {
        return boardDao.getContentCnt(paramMap);
    }
    
	//====================================================================
    //board search
    @Override
    public List<Board> getSearch(Map<String, Object> paramMap)throws Exception {
    	return boardDao.getSearch(paramMap);
    }
    
	//====================================================================
    //board isPassword

    //---------------------------------------------------------
    //file Upload
    @Override
    public boolean fileUpload(Map<String, Object> paramMap, MultipartHttpServletRequest mRequest)throws Exception {

    	boolean isSuccess = false;

    	File dir = new File(uploadPath);

    	if (!dir.isDirectory()) {
    		dir.mkdirs();
    	}
    	
    	paramMap.put("filePath", uploadPath);

    	Iterator<String> iter = mRequest.getFileNames();
    	int count = 0;
    	
    	while(iter.hasNext()) {
    		count++;
    		String uploadFileName = iter.next();
    		MultipartFile mFile = mRequest.getFile(uploadFileName);
    		String originalFileName = mFile.getOriginalFilename();
    		
    		String saveFileName = originalFileName;
    		System.out.println(saveFileName);
    		System.out.println(count);
    		UUID uuid = UUID.randomUUID();
    	
    		if(saveFileName != null && !saveFileName.equals("")) {
    			if(new File(uploadPath + saveFileName).exists()) {
    				saveFileName = uuid + saveFileName;
    				System.out.println(saveFileName);
    				if(count == 1) {paramMap.put("fileName1", saveFileName);}
    				if(count == 2) {paramMap.put("fileName2", saveFileName);}
    			}
    			try {

    				mFile.transferTo(new File(uploadPath + saveFileName));

    				isSuccess = true;				

    			} catch (IllegalStateException e) {

    				e.printStackTrace();

    				isSuccess = false;

    			} catch (IOException e) {

    				e.printStackTrace();

    				isSuccess = false;
    			}
    		} // if end
    	} // while end
    	return isSuccess;
    } // fileUpload end


}
