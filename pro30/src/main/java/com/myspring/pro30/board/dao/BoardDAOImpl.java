package com.myspring.pro30.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllArticlesList() throws Exception {
		List<ArticleVO> articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}
	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException{
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO",articleNO);
		sqlSession.insert("mapper.board.insertNewArticle",articleMap);
		return articleNO;
	}
	
	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle",articleNO); 
	}
	
	@Override
	public void viewsUpdate(int articleNO) throws DataAccessException {
		 sqlSession.update("mapper.board.viewsUpdate",articleNO); 
	}
	
	@Override
	public List selectImageFileList(int articleNO) {
		return sqlSession.selectList("mapper.board.selectImageFileList",articleNO);
	}
	@Override
	public void updateArticle(Map articleMap) throws DataAccessException{

		sqlSession.update("mapper.board.updateArticle",articleMap);
	}
	@Override
	public void updateImageFileList(Map articleMap) throws DataAccessException{

		Map temp = new HashMap();
		List list = (ArrayList)articleMap.get("imageFileList");
		List rmList = (ArrayList)articleMap.get("removeFileList");
		
		for(int i=0; i<rmList.size();i++) {
			String fileName = ((ImageVO)list.get(i)).getImageFileName();
			int fileNO = (Integer)rmList.get(i);

			temp.put("fileName", fileName);
			temp.put("fileNO", fileNO); 
			sqlSession.update("mapper.board.updateImageFileList",temp);

		}

	}
	
	public List<ImageVO> removeImageList(Map articleMap) throws DataAccessException{
		List rmList = (ArrayList)articleMap.get("removeFileList");
		List<ImageVO> removeList = sqlSession.selectList("mapper.board.removeImageList",rmList);
		System.out.println(removeList);
		return removeList;
	}
	
	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle",articleNO);
	}
	
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		if(imageFileList.size()>1) {
			sqlSession.insert("mapper.board.insertNewImage",imageFileList);
		}else {
			sqlSession.insert("mapper.board.insertOneImage",imageFileList.get(0));
		}
		
	}
	
	private int selectNewArticleNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}

	private int selectNewImageFileNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}

	
	 
}
