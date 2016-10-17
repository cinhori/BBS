package com.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bbs.bean.Comment;
import com.bbs.control.impl.CommentImpl;
import com.bbs.control.inter.CommentInter;

@WebServlet("/SeeReplyServlet")
public class SeeReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid")+"");
		int articleid = Integer.parseInt(request.getParameter("articleid")+"");
		
		CommentInter commentInter = new CommentImpl();
		List<Comment> commentList = commentInter.getCommentDetail(userid, articleid);
		if(commentList == null){
			JOptionPane.showMessageDialog(null, "没有评论");
			response.sendRedirect("jsp/show.jsp");
		}else{
			request.getSession().setAttribute("commentList", commentList);
			response.sendRedirect("jsp/seereply.jsp");
		}
	}

}
