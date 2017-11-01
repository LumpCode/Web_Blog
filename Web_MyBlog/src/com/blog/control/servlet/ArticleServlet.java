package com.blog.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.blog.model.entity.Article;
import com.blog.model.entity.Comment;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;
import com.blog.model.service.ArticleService;
import com.blog.model.service.CommentService;
import com.blog.model.service.Impl.ArticleServiceImpl;
import com.blog.model.service.Impl.CommentServiceImpl;

public class ArticleServlet extends HttpServlet {

	private static final long serialVersionUID = -2951357541386543115L;

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
		String action = request.getParameter("action");
		//实例化文章服务层接口
		ArticleService as = new ArticleServiceImpl();
		
		if ("all".equals(action)) {
			// 获取所有文章信息
			List<Article> alist = as.getAllArticleInfoService();
			Notice notice = as.getNoticeService();
			request.setAttribute("notice", notice);
			session.setAttribute("allArt", alist);
			request.getRequestDispatcher("showAllArticle.jsp").forward(request,
				response);
			//response.sendRedirect("showAllArticle.jsp");
		} else if ("one".equals(action)) {
			// 获取个人所有文章信息
			if(session.getAttribute("user")==null){
	  			response.sendRedirect("index.jsp");
	  			return;
	  		}
			User user = (User) session.getAttribute("user");
			List<Article> list = as.getOneUserArticleInfoService(user.getUid());
			session.setAttribute("oneArt", list);
			response.sendRedirect("user/showUserAllArticle.jsp");
		} else if ("add".equals(action)) {
			//添加文章
			User user = (User) session.getAttribute("user");
			Article art = new Article();
			art.setTitle(request.getParameter("title"));
			art.setContent(request.getParameter("content_html"));
			art.setP_date(request.getParameter("time"));
			art.setUid(user.getUid());
			art.setUserName(user.getUserName());
			if (as.addArtService(art)) {
				// 写入成功
				request.setAttribute("url", "ArticleServlet?action=all");
				request.setAttribute("info", "提交成功");
				request.getRequestDispatcher("success.jsp").forward(request,
						response);
			} else {
				// 写入失败
				request.setAttribute("url", "user/addArticle.jsp");
				request.setAttribute("info", "提交失败");
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}

		}else if ("look".equals(action)){
			//查看文章
			int aid = Integer.parseInt(request.getParameter("aid"));
			Article art = as.getArticleService(aid);
			if(art.equals("") || art.equals(null)){
				System.out.println("文章对象为空");
			}else{
			  //实例化文章评论查询接口
			    CommentService cs = new CommentServiceImpl();
			    as.addClickNumService(aid);
			    request.setAttribute("art", art);
			    List<Comment> clist = cs.getAllCommentService(aid);
			    request.setAttribute("clist", clist);
			    request.getRequestDispatcher("user/showArticle.jsp").forward(request,
						response);
			}
		}else if("delete".equals(action)){
		    int aid = Integer.parseInt(request.getParameter("aid"));
		    if(as.delArticleService(aid)){
			response.sendRedirect("ArticleServlet?action=one");
		    }else{
			request.setAttribute("url", "ArticleServlet?action=one");
			request.setAttribute("info", "删除失败");
			request.getRequestDispatcher("error.jsp").forward(request,
					response);
		    }
		}else if("update".equals(action)){
		    int aid = Integer.parseInt(request.getParameter("aid"));
		    Article art = as.getArticleService(aid);
		    request.setAttribute("updateArt", art);
		    request.getRequestDispatcher("user/updateArticle.jsp").forward(request,
				response);
		}else if("updateArt".equals(action)){
		    int aid = Integer.parseInt(request.getParameter("aid"));
		    Article art = new Article();
		    art.setAid(aid);
		    art.setTitle(request.getParameter("title"));
		    art.setContent(request.getParameter("content_html"));
		    art.setP_date(request.getParameter("time"));
		    if(as.updateArticleService(art)){
			response.sendRedirect("ArticleServlet?action=look&aid="+aid);
		    }else{
			request.setAttribute("url", "ArticleServlet?action=update");
			request.setAttribute("info", "更新失败");
			request.getRequestDispatcher("error.jsp").forward(request,
					response);
		    }
		}

	}
}
