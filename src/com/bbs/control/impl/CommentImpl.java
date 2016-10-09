package com.bbs.control.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.bean.Comment;
import com.bbs.control.inter.CommentInter;
import com.bbs.util.DBUtil;

public class CommentImpl implements CommentInter {

	public boolean saveComment(Comment comment) {

		Connection connection = DBUtil.getConn();
		String sql = "insert into comment values (null,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, comment.getCommenttext() + "");
			preparedStatement.setString(2, comment.getCommenttime() + "");
			preparedStatement.setString(3, comment.getUserid() + "");
			preparedStatement.setString(4, comment.getArticleid() + "");
			int isOk = preparedStatement.executeUpdate();
			if (isOk > 0) {
				return !flag;
			} else {
				return flag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(connection, null, preparedStatement, null);
		return flag;
	}

	public List<Comment> getCommentDetail(int userid, int articleid) {
		Connection connection = DBUtil.getConn();
		String sql = "select * from comment c where c.articleid=?";// 缂栧啓sql璇彞锛岀涓�涓瓧娈典笉闇�瑕佹彃鍏ワ紝鏄嚜鍔ㄥ鍔犵殑
		PreparedStatement preparedStatement = null;
		List<Comment> commentList = new ArrayList<Comment>();
		try {
			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, userid);
			preparedStatement.setInt(1, articleid);
			// 杩欓噷鐨勪骇璁笉闇�瑕佷紶鍏ql璇彞
			ResultSet rs = preparedStatement.executeQuery();

			// 鍒ゆ柇鏄惁涓虹┖

			while (rs.next()) {// 灏嗕俊鎭凯浠ｅ埌list涓�
				Comment comment = new Comment();
				comment.setCommentid(rs.getInt("commentid"));
				comment.setCommenttext(rs.getString("commenttext"));
				comment.setCommenttime(rs.getString("commenttime"));
				comment.setUserid(rs.getInt("userid"));
				comment.setArticleid(rs.getInt("articleid"));

				commentList.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(connection, null, preparedStatement, null);
		return commentList;
	}
}
