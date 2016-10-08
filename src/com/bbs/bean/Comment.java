package com.bbs.bean;

public class Comment {
	private int commentid;
	private String commenttext;
	private String commenttime;
	private int userid;
	private int articleid;

	public Comment() {
	}

	public Comment(String commenttext, String commenttime, int userid,
			int articleid) {
		this.commenttext = commenttext;
		this.commenttime = commenttime;
		this.userid = userid;
		this.articleid = articleid;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	public String getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

}
