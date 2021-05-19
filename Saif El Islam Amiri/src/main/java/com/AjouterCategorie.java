package com;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategorieManager;

/**
 * Servlet implementation class AjouterCategorie
 */
@WebServlet("/AjouterCategorie")
public class AjouterCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
     CategorieManager m ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		m = new CategorieManager();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c = request.getParameter("categ");
		m.ajouterCategorie(c);
		response.sendRedirect("ajouterLivre.jsp");
	}

}
