package com.blog.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;
import com.blog.model.service.AdminService;
import com.blog.model.service.Impl.AdminServiceImpl;

public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = -8305703659636863396L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// 设置编码格式
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("UTF-8");
	//创建session获取action动作
	HttpSession session = request.getSession();
	AdminService as = new AdminServiceImpl();
	String action = request.getParameter("action");
	if("all".equals(action)){
	    List<Article> alist = as.getAllArticleInfoService();
	    session.setAttribute("Alist", alist);
	    response.sendRedirect("admin/Article/index.jsp");
	}else if("del".equals(action)){
	    //删除文章
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    try {
		as.delArticleService(aid);
		session.removeAttribute("Alist");
	    } catch (Exception e) {
		e.printStackTrace();
		System.out.println("管理员删除文章失败");
	    }
	}else if("notice".equals(action)){
	    //查看所有公告
	    List<Notice> nlist = as.getAllNoticeInfoService();
	    session.setAttribute("Nlist", nlist);
	    response.sendRedirect("admin/Notice/index.jsp");
	}else if("One".equals(action)){
	    int nid = Integer.parseInt(request.getParameter("nid"));
	    Notice notice = as.getOneNoticeService(nid);
	    session.setAttribute("OneNotice", notice);
	    response.sendRedirect("admin/Notice/edit.jsp");
	}else if("edit".equals(action)){
	    int nid = Integer.parseInt(request.getParameter("nid"));
	    String noticeTitle = request.getParameter("grouptitle");
	    String noticeDetail = request.getParameter("content");
	    int status = Integer.parseInt(request.getParameter("status"));
	    Notice notice = new Notice(nid,noticeTitle,noticeDetail,status);
	    if(as.updateNoticeService(notice)){
		response.sendRedirect("AdminServlet?action=notice");
	    }else{
		response.sendRedirect("admin/Notice/edit.jsp");
	    }
	}else if("add".equals(action)){
	    String noticeTitle = request.getParameter("grouptitle");
	    String noticeDetail = request.getParameter("noticeDetail");
	    int status = Integer.parseInt(request.getParameter("status"));
	    Notice notice = new Notice(noticeTitle,noticeDetail,status);
	    if(as.addNoticeService(notice)){
		response.sendRedirect("AdminServlet?action=notice");
	    }else{
		response.sendRedirect("admin/Notice/add.jsp");
	    }
	}else if("allUser".equals(action)){
	    List<User> ulist= as.getAllUserInfoService();
	    session.setAttribute("ulist", ulist);
	    response.sendRedirect("admin/User/index.jsp");
	}else if("oneUser".equals(action)){
	    int uid = Integer.parseInt(request.getParameter("uid"));
	    User oneUser = as.getOneUserInfoService(uid);
	    session.setAttribute("oneUser", oneUser);
	    response.sendRedirect("admin/User/edit.jsp");
	}else if("updateUser".equals(action)){
	    int uid = Integer.parseInt(request.getParameter("uid"));
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String realname = request.getParameter("realname");
	    String email = request.getParameter("email");
	    int status = Integer.parseInt(request.getParameter("status"));
	    User user = new User(uid,username,password,realname,email,status);
	    if(as.updateUserInfoService(user)){
		response.sendRedirect("AdminServlet?action=allUser");
	    }else{
		response.sendRedirect("admin/User/edit.jsp");
	    }
	}
    }

}
