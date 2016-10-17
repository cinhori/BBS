package com.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.bbs.bean.User;
import com.bbs.control.impl.UserImpl;
import com.bbs.control.inter.UserInter;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkPassword = request.getParameter("checkpassword");
		
		//鍒ゆ柇涓ゆ杈撳叆鐨勫瘑鐮佹槸鍚︾浉鍚�
		if(password.equals(checkPassword)){
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserInter userInter = new UserImpl();
			if(userInter.register(user)){
				JOptionPane.showMessageDialog(null, "娉ㄥ唽鎴愬姛锛�");
				response.sendRedirect("jsp/login.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "娉ㄥ唽澶辫触锛�");
				response.sendRedirect("jsp/register.jsp");
			}
		}else{
			JOptionPane.showMessageDialog(null, "瀵嗙爜涓嶄竴鑷�");
			response.sendRedirect("jsp/register.jsp");
		}
	}

}
