package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserDao;
import model.User;

@WebServlet(name = "user", urlPatterns = { "/user" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("registerUser".equals(action)) {
			registerUser(request, response);
		} else if ("loginUser".equals(action)) {
			loginUser(request, response);
		}
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);

		if (userDao.addUser(newUser)) {
			request.setAttribute("message", "Registration successful. Please login.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Registration failed. Please try again.");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		userDao.closeConnection();
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		User user = userDao.getUserByUsernameAndPassword(username, password);

		if (user != null) {
			// Kullanıcı var, giriş başarılı
			HttpSession sessionUser = request.getSession(true);
			sessionUser.setAttribute("user", user);
			
			 Cookie test = new Cookie("message","message");
			 test.setMaxAge(60*60*1);
			 response.addCookie(test);

//			request.getRequestDispatcher("/home.jsp").forward(request, response);
			response.sendRedirect("index.jsp");
			} else {
			// Kullanıcı yok, giriş başarısız
			request.setAttribute("message", "Login failed. Please check your username and password.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		userDao.closeConnection();
	}

}
