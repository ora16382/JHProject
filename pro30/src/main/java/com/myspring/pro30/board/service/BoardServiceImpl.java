package com.myspring.pro30.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.board.dao.BoardDAO;
import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

@Transactional(propagation = Propagation.REQUIRED)
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<ArticleVO> listArticles() throws Exception {
		List<ArticleVO> articlesList = boardDAO.selectAllArticlesList();
		return articlesList;
	}
	
	@Override
	public int addNewArticle(Map articleMap) throws Exception{
		int articleNO = boardDAO.insertNewArticle(articleMap);
		if(articleMap.get("imageFileList")!=null) {
		boardDAO.insertNewImage(articleMap);
		}
		return articleNO;
	}
	
	@Override
	public Map viewArticle(int articleNO) throws Exception{
		Map articleMap = new HashMap();
		boardDAO.viewsUpdate(articleNO);
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
		articleMap.put("article", articleVO);
		articleMap.put("imageFileList", imageFileList);
		return articleMap;
	}
	
	@Override
	public List modArticle(Map articleMap) throws Exception{
		boardDAO.updateArticle(articleMap);
		List list = boardDAO.removeImageList(articleMap);
		boardDAO.updateImageFileList(articleMap);
		return list;
	}

	@Override
	public void removeArticle(int articleNo) throws Exception {
		boardDAO.deleteArticle(articleNo);
	}
}
