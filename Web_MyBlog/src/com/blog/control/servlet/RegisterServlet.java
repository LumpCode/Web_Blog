package com.blog.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.entity.User;
import com.blog.model.service.UserService;
import com.blog.model.service.Impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 9016303448185948051L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����������Ӧ�����ʽ
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//��ȡע����Ϣ
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPwd(request.getParameter("password"));
		user.setNickName(request.getParameter("nickname"));
		user.setEmail(request.getParameter("email"));
		//ʵ�����ӿ�
		UserService us = new UserServiceImpl();
		if(us.registerService(user)) {
			request.setAttribute("url", "index.jsp");
			request.setAttribute("info", "ע��ɹ�");
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		}else {
			request.setAttribute("url", "register.jsp");
			request.setAttribute("info", "ע��ʧ��");
			request.getRequestDispatcher("error.jsp").forward(request,
					response);
		}
		
	}

}
