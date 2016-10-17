package com.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bbs.bean.User;
import com.bbs.control.impl.UserImpl;
import com.bbs.control.inter.UserInter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//根据用户信息查找用户
		UserInter userInter = new UserImpl();
		User user = userInter.login(username, password);
		
		if (user != null) {  

			// 将用户存放到session中去
			request.getSession().setAttribute("user", user);
			response.sendRedirect("jsp/leavemessage.jsp");

		} else {
			System.out.println("LoginServlet��¼ʧ��");
			JOptionPane.showMessageDialog(null, "��¼ʧ��");
			response.sendRedirect("jsp/login.jsp");
		}
	}
}
