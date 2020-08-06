package com.myspring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

public interface BoardDAO {
	public List selectAllArticlesList() throws Exception;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	public ArticleVO selectArticle(int articleNO) throws DataAccessException;
	public void updateArticle(Map articleMap) throws DataAccessException;
	public void deleteArticle(int articleNO) throws DataAccessException;
	public void insertNewImage(Map articleMap) throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;
	public void updateImageFileList(Map articleMap) throws DataAccessException;
	public List<ImageVO> removeImageList(Map articleMap) throws DataAccessException;
	public void viewsUpdate(int articleNO) throws DataAccessException;
}
