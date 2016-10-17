package com.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bbs.bean.Comment;
import com.bbs.control.impl.CommentImpl;
import com.bbs.control.inter.CommentInter;

@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid") + "");
		String time = request.getParameter("time");
		int articleid = Integer.parseInt(request.getParameter("articleid")+"");
		String context = request.getParameter("context");
		String commenttext = request.getParameter("textareaText");
		
		if(commenttext.equals("")){
			JOptionPane.showMessageDialog(null, "评论不能为空");
			request.getRequestDispatcher("jsp/reply.jsp").forward(request, response);
		}else{
			//String commenttext, String commenttime, int userid,int articleid
			Comment comment = new Comment(commenttext,time,userid,articleid);
			CommentInter commentInter = new CommentImpl();
			if(commentInter.saveComment(comment)){
				JOptionPane.showMessageDialog(null, "评论保存成功");
				response.sendRedirect("jsp/show.jsp");
			}else{
				JOptionPane.showMessageDialog(null, "评论无法保存");
				request.getRequestDispatcher("jsp/reply.jsp").forward(request, response);
			}
		}
	}
}
