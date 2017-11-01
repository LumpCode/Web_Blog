package com.blog.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.entity.Comment;
import com.blog.model.service.CommentService;
import com.blog.model.service.Impl.CommentServiceImpl;

public class CommentServlet extends HttpServlet {

    private static final long serialVersionUID = 3155381299376060396L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// ���ñ����ʽ
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("UTF-8");
	// ����session��ȡaction����
//	HttpSession session = request.getSession();
	String action = request.getParameter("action");
	//ʵ�������²�ѯ�ӿ�
	CommentService cs = new CommentServiceImpl();
	if("add".equals(action)){
	    Comment com = new Comment();
	    com.setAid(Integer.parseInt(request.getParameter("aid")));
	    com.setContent(new String(request.getParameter("content").getBytes("iso8859-1"),"UTF-8"));
	    com.setUserName(new String(request.getParameter("userName").getBytes("iso8859-1"),"UTF-8"));
	    com.setCmtDate(request.getParameter("cmtDate"));
	    if(cs.addCommentService(com)){
		System.out.println("���۳ɹ�");
	    }else{
		System.out.println("����ʧ��");
	    }
	    
	}
    }

}
