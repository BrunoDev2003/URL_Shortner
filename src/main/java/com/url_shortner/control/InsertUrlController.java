package com.url_shortner.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.url_shortner.persistence.linkDAO;

/**
 * Servlet implementation class InsertUrlController
 */
@WebServlet("/InsertUrlController")
public class InsertUrlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUrlController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String msg = "Deu certo!";
		
		try {
			linkDAO linkDAO = new linkDAO();
			if(!linkDAO.create("url")) {
				msg = "Deu Ruim";
			}
			
		} catch(Exception err) {
			msg = err.getMessage();
		}
		
		request.setAttribute("msg", response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");
	}

}
