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
	// 设置请求响应编码格式
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	// 获取用户名密码
	String userName = request.getParameter("username");
	String pwd = request.getParameter("password");
	String identity = request.getParameter("identity");
	// 实例化服务层接口
	UserService us = new UserServiceImpl();
	User user = us.loginService(userName, pwd);
	HttpSession session = request.getSession();
	String uName = user.getUserName();
	String pwsd = user.getPwd();
	String action = request.getParameter("action");

	if ("login".equals(action)) {
	    // 判断用户身份(如果是用户)
	    if ("user".equals(identity)) {
		if (userName.equals(uName) && pwd.equals(pwsd) && user.getStatus()==1) {
		    // 如果存在数据库返回的User对象且匹配,就将user对象放到session里
		    session.setAttribute("user", user);
		    // 将显示的内容转发到success.jsp登陆成功页面
		    request.setAttribute("url", "ArticleServlet?action=one");
		    request.setAttribute("info", "登陆成功");
		    request.getRequestDispatcher("success.jsp").forward(
			    request, response);
		} else {
		    /*
		     * request.setAttribute("msg",
		     * "<h2 style='color:red'>用户名或密码错误!</h2>");
		     * request.getRequestDispatcher("index.jsp")
		     * .forward(request, response);
		     */
		    request.setAttribute("url", "index.jsp");
		    request.setAttribute("info", "登陆失败");
		    request.getRequestDispatcher("error.jsp").forward(request,
			    response);
		}
	    } else if ("admin".equals(identity)) {
		Admin admin = new Admin();
		admin.setAdminName(userName);
		admin.setAdminPwd(pwd);
		AdminService as = new AdminServiceImpl();
		
		if (as.loginAdminService(admin)) {
		    // 如果存在数据库返回的admin对象且匹配,就将admin对象放到session里
		    session.setAttribute("admin", admin);
		    // 将显示的内容转发到success.jsp登陆成功页面
		    request.setAttribute("url", "admin/index.jsp");
		    request.setAttribute("info", "登陆成功,3秒钟后自动跳转到管理员页面");
		    request.getRequestDispatcher("success.jsp").forward(
			    request, response);
		} else {
		    request.setAttribute("url", "index.jsp");
		    request.setAttribute("info", "登陆失败");
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
		request.setAttribute("info", "修改成功,3秒钟后自动跳转到登陆页面");
		request.getRequestDispatcher("success.jsp").forward(request,
			response);
	    } else {
		request.setAttribute("url", "user/editUserInfo.jsp");
		request.setAttribute("info", "修改失败");
		request.getRequestDispatcher("error.jsp").forward(request,
			response);
	    }

	}

    }
}
