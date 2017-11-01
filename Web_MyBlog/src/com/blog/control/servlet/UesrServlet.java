package com.blog.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.model.entity.Admin;
import com.blog.model.entity.User;
import com.blog.model.service.AdminService;
import com.blog.model.service.UserService;
import com.blog.model.service.Impl.AdminServiceImpl;
import com.blog.model.service.Impl.UserServiceImpl;

public class UesrServlet extends HttpServlet {

    private static final long serialVersionUID = 8854525470424389945L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// ����������Ӧ�����ʽ
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	// ��ȡ�û�������
	String userName = request.getParameter("username");
	String pwd = request.getParameter("password");
	String identity = request.getParameter("identity");
	// ʵ���������ӿ�
	UserService us = new UserServiceImpl();
	User user = us.loginService(userName, pwd);
	HttpSession session = request.getSession();
	String uName = user.getUserName();
	String pwsd = user.getPwd();
	String action = request.getParameter("action");

	if ("login".equals(action)) {
	    // �ж��û����(������û�)
	    if ("user".equals(identity)) {
		if (userName.equals(uName) && pwd.equals(pwsd) && user.getStatus()==1) {
		    // ����������ݿⷵ�ص�User������ƥ��,�ͽ�user����ŵ�session��
		    session.setAttribute("user", user);
		    // ����ʾ������ת����success.jsp��½�ɹ�ҳ��
		    request.setAttribute("url", "ArticleServlet?action=one");
		    request.setAttribute("info", "��½�ɹ�");
		    request.getRequestDispatcher("success.jsp").forward(
			    request, response);
		} else {
		    /*
		     * request.setAttribute("msg",
		     * "<h2 style='color:red'>�û������������!</h2>");
		     * request.getRequestDispatcher("index.jsp")
		     * .forward(request, response);
		     */
		    request.setAttribute("url", "index.jsp");
		    request.setAttribute("info", "��½ʧ��");
		    request.getRequestDispatcher("error.jsp").forward(request,
			    response);
		}
	    } else if ("admin".equals(identity)) {
		Admin admin = new Admin();
		admin.setAdminName(userName);
		admin.setAdminPwd(pwd);
		AdminService as = new AdminServiceImpl();
		
		if (as.loginAdminService(admin)) {
		    // ����������ݿⷵ�ص�admin������ƥ��,�ͽ�admin����ŵ�session��
		    session.setAttribute("admin", admin);
		    // ����ʾ������ת����success.jsp��½�ɹ�ҳ��
		    request.setAttribute("url", "admin/index.jsp");
		    request.setAttribute("info", "��½�ɹ�,3���Ӻ��Զ���ת������Աҳ��");
		    request.getRequestDispatcher("success.jsp").forward(
			    request, response);
		} else {
		    request.setAttribute("url", "index.jsp");
		    request.setAttribute("info", "��½ʧ��");
		    request.getRequestDispatcher("error.jsp").forward(request,
			    response);
		}
	    }
	} else if ("update".equals(action)) {
	    User use = new User();
	    use.setUid(Integer.parseInt(request.getParameter("uid")));
	    use.setNickName(request.getParameter("nickName"));
	    use.setQianMing(request.getParameter("qianMing"));
	    use.setUserName(request.getParameter("userName"));
	    use.setPwd(request.getParameter("pwd"));
	    use.setEmail(request.getParameter("email"));
	    if (us.updateUserInfoService(use)) {// &&us.checkNickService(use.getNickName())
		request.setAttribute("url", "index.jsp");
		request.setAttribute("info", "�޸ĳɹ�,3���Ӻ��Զ���ת����½ҳ��");
		request.getRequestDispatcher("success.jsp").forward(request,
			response);
	    } else {
		request.setAttribute("url", "user/editUserInfo.jsp");
		request.setAttribute("info", "�޸�ʧ��");
		request.getRequestDispatcher("error.jsp").forward(request,
			response);
	    }

	}

    }
}
