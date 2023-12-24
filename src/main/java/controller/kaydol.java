package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class kaydol
 */
@WebServlet("/kaydol")
public class kaydol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kaydol() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String cinsiyet = request.getParameter("cinsiyet");
		String sifre = request.getParameter("sifre");
		
		String cizim = request.getParameter("cizim");
		String tasarim = request.getParameter("tasarim");
		String yoga = request.getParameter("yoga");
		String enstruman = request.getParameter("enstruman");
		String blog = request.getParameter("blog");
		String vlogger = request.getParameter("vlogger");
		
		var out = response.getWriter();
out.print(vlogger);
	}

}
