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
		// ���ñ����ʽ
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		//����session��ȡaction����
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		//ʵ�������·����ӿ�
		ArticleService as = new ArticleServiceImpl();
		
		if ("all".equals(action)) {
			// ��ȡ����������Ϣ
			List<Article> alist = as.getAllArticleInfoService();
			Notice notice = as.getNoticeService();
			request.setAttribute("notice", notice);
			session.setAttribute("allArt", alist);
			request.getRequestDispatcher("showAllArticle.jsp").forward(request,
				response);
			//response.sendRedirect("showAllArticle.jsp");
		} else if ("one".equals(action)) {
			// ��ȡ��������������Ϣ
			if(session.getAttribute("user")==null){
	  			response.sendRedirect("index.jsp");
	  			return;
	  		}
			User user = (User) session.getAttribute("user");
			List<Article> list = as.getOneUserArticleInfoService(user.getUid());
			session.setAttribute("oneArt", list);
			response.sendRedirect("user/showUserAllArticle.jsp");
		} else if ("add".equals(action)) {
			//�������
			User user = (User) session.getAttribute("user");
			Article art = new Article();
			art.setTitle(request.getParameter("title"));
			art.setContent(request.getParameter("content_html"));
			art.setP_date(request.getParameter("time"));
			art.setUid(user.getUid());
			art.setUserName(user.getUserName());
			if (as.addArtService(art)) {
				// д��ɹ�
				request.setAttribute("url", "ArticleServlet?action=all");
				request.setAttribute("info", "�ύ�ɹ�");
				request.getRequestDispatcher("success.jsp").forward(request,
						response);
			} else {
				// д��ʧ��
				request.setAttribute("url", "user/addArticle.jsp");
				request.setAttribute("info", "�ύʧ��");
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}

		}else if ("look".equals(action)){
			//�鿴����
			int aid = Integer.parseInt(request.getParameter("aid"));
			Article art = as.getArticleService(aid);
			if(art.equals("") || art.equals(null)){
				System.out.println("���¶���Ϊ��");
			}else{
			  //ʵ�����������۲�ѯ�ӿ�
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
			request.setAttribute("info", "ɾ��ʧ��");
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
			request.setAttribute("info", "����ʧ��");
			request.getRequestDispatcher("error.jsp").forward(request,
					response);
		    }
		}

	}
}
