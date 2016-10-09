package com.bbs.control.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbs.bean.Article;
import com.bbs.control.inter.ArticleInter;
import com.bbs.util.DBUtil;

public class ArticleImpl implements ArticleInter {

	public boolean saveMessage(Article article) {

		Connection connection = DBUtil.getConn();
		String sql = "insert into article(title, context, articletime, userid) values (?,?,?,?)";// 缂栧啓sql璇彞锛岀涓�涓瓧娈典笉闇�瑕佹彃鍏ワ紝鏄嚜鍔ㄥ鍔犵殑
		PreparedStatement preparedStatement = null;
		boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, article.getTitle() + "");
			preparedStatement.setString(2, article.getContext() + "");
			preparedStatement.setString(3, article.getArticleTime() + "");
			preparedStatement.setString(4, article.getUserid() + "");
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

	public List<Article> getArticleMessage() {
		Connection connection = DBUtil.getConn();
		String sql = "select * from article";// 缂栧啓sql璇彞锛岀涓�涓瓧娈典笉闇�瑕佹彃鍏ワ紝鏄嚜鍔ㄥ鍔犵殑
		Statement statement = null;
		List<Article> articleList = new ArrayList<Article>();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			//鍒ゆ柇鏄惁涓虹┖
			if (rs.next()) {
				while (rs.next()) {//灏嗕俊鎭凯浠ｅ埌list涓�
					Article article = new Article();
					article.setTitle(rs.getString("title"));
					article.setContext(rs.getString("context"));
					article.setArticleTime(rs.getString("articletime"));
					article.setUserid(rs.getInt("userid"));
					article.setArticleid(rs.getInt("articleid"));
					articleList.add(article);
				}
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(connection, statement, null, null);
		return articleList;
	}
}
