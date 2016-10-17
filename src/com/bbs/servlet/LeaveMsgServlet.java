package com.bbs.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bbs.bean.Article;
import com.bbs.bean.User;
import com.bbs.control.impl.ArticleImpl;
import com.bbs.control.inter.ArticleInter;

@WebServlet("/LeaveMsgServlet")
public class LeaveMsgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String context = request.getParameter("textareaText");
		if (title.equals("") || context.equals("")) {
			System.out.println("标题或消息为空");
			JOptionPane.showMessageDialog(null, "请输入标题和消息");
 			response.sendRedirect("jsp/leavemessage.jsp");
		} else {
			SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String articleTime = matter.format(new Date());

			User user = (User) request.getSession().getAttribute("user");
			int userId = user.getUserId();

			Article article = new Article(title, context, userId, articleTime);
			ArticleInter articleInter = new ArticleImpl();

			if (articleInter.saveMessage(article)) {
				JOptionPane.showMessageDialog(null, "消息保存成功");
				response.sendRedirect("jsp/show.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "消息保存失败");
			}
		}
	}
}
