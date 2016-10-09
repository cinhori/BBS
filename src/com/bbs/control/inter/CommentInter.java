package com.bbs.control.inter;

import java.util.List;

import com.bbs.bean.Comment;

public interface CommentInter {
	
	/**
	 * 淇濆瓨鍥炲鐨勬秷鎭�
	 * @param comment
	 * @return
	 */
	public boolean saveComment(Comment comment);
	
	public List<Comment> getCommentDetail(int userid,int articleid);
}
