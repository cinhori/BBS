package com.bbs.bean;

public class Article {

	private int articleid;
	private String title;
	private String context;
	private int userid;
	private String articleTime;

	public Article() {
	}

	public Article(String title, String context, int userid, String articleTime) {
		this.title = title;
		this.context = context;
		this.userid = userid;
		this.articleTime = articleTime;
	}

	public String getArticleTime() {
		return articleTime;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

	public void setArticleTime(String articleTime) {
		this.articleTime = articleTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
