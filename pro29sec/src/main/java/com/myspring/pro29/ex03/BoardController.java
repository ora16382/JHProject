package com.myspring.pro29.ex03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<ArticleVO>> listArticles(){
		logger.info("listArticles �޼��� ȣ��");
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		for(int i=0; i<10; i++) {
			ArticleVO vo = new ArticleVO();
			vo.setArticleNO(i);
			vo.setWriter("������"+i);
			vo.setTitle("�ȳ��ϼ���"+i);
			vo.setContent("����ǰ �Ұ�"+i);
			list.add(vo);
		}
		
		return new ResponseEntity<List<ArticleVO>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{articleNO}",method=RequestMethod.GET)
	public ResponseEntity<ArticleVO> findArticle(@PathVariable("articleNO") Integer articleNO){
		logger.info("findArticle �޼��� ȣ��");
		ArticleVO vo = new ArticleVO();
		vo.setArticleNO(articleNO);
		vo.setWriter("ȫ�浿");
		vo.setTitle("�ȳ��ϼ���");
		vo.setContent("ȫ�浿 ���Դϴ�.");
		return new ResponseEntity<ArticleVO>(vo,HttpStatus.OK);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<ArticleVO> addArticle(@RequestBody ArticleVO articleVO, HttpServletRequest request){
		HttpHeaders responseHeaers = new HttpHeaders();
		//responseHeaers.add("Content-type","text/html; charset=utf-8");
		ResponseEntity<ArticleVO> resEntity = null;
		articleVO.setContent("sexParty");
		try {
			logger.info("addArticle �޼��� ȣ��");
		//	logger.info(articleVO.toString());
			resEntity = new ResponseEntity<ArticleVO>(articleVO,HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<ArticleVO>(articleVO,HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@RequestMapping(value="/{articleNO}",method=RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO, @RequestBody ArticleVO articleVO){
		
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("modArticle �޼��� ȣ��");
			logger.info(articleVO.toString());
			resEntity = new ResponseEntity<String>("MDD_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
	
	@RequestMapping(value="/{articleNO}",method=RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle(@PathVariable("articleNO") Integer articleNO){
		
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("removeArticle �޼��� ȣ��");
			resEntity = new ResponseEntity<String>("REMOVE_SUCCEEDED",HttpStatus.OK);
		}catch(Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
}
