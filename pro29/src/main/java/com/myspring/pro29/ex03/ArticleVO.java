package com.myspring.pro29.ex03;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ArticleVO {
	private int articleNO;
	private String writer;
	private String title;
	private String content;
	
	
	public ArticleVO() {
		
	}


	public ArticleVO(int articleNO, String title, String content, String writer) {
		super();
		this.articleNO = articleNO;
		this.title = title;
		this.content = content;
		this.content = writer;
	}


	public int getArticleNO() {
		return articleNO;
	}


	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	
	
}