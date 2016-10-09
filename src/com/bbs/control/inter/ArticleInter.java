package com.bbs.control.inter;

import java.util.List;

import com.bbs.bean.Article;

public interface ArticleInter {

	/**
	 * 保存文章
	 * 
	 * @param article
	 * @return
	 */
	public boolean saveMessage(Article article);

	/**
	 * 获取文章信息
	 * 
	 * @return
	 */
	public List<Article> getArticleMessage();
}
