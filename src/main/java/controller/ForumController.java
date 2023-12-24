package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import database.MessageDao;
import database.TopicDao;
import model.Message;
import model.Topic;

@WebServlet("/forum/servlet")
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForumController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		System.out.println(action);
		if ("listTopics".equals(action)) {
			listTopics(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("createTopic".equals(action)) {
			createTopic(request, response);
		} else if ("updateTopic".equals(action)) {
//			updateTopic(request, response);
		} else if ("addMessage".equals(action)) {
			addMessage(request, response);
		}
	}

	private void listTopics(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TopicDao topicDao = new TopicDao();
		List<Topic> topics = topicDao.getAllTopics();
		topicDao.closeConnection();

		request.setAttribute("topics", topics);
		request.getRequestDispatcher("/listTopics.jsp").forward(request, response);
	}

	private void createTopic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String topicTitle = request.getParameter("topicTitle");

		TopicDao topicDao = new TopicDao();
		Topic newTopic = new Topic();
		newTopic.setTitle(topicTitle);
		topicDao.addTopic(newTopic);
		topicDao.closeConnection();

		request.setAttribute("message", "Forum başlığı başarıyla oluşturuldu.");
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	private void addMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String topicIdString = request.getParameter("topicId");
		String messageContent = request.getParameter("messageContent");

		ObjectId topicId = new ObjectId(topicIdString);

		MessageDao messageDao = new MessageDao();
		Message newMessage = new Message();
		newMessage.setTopicId(topicId);
		newMessage.setContent(messageContent);
		messageDao.addMessage(newMessage);
		messageDao.closeConnection();

		// Yönlendirme: Topic detayları sayfasına geri dön
		request.setAttribute("message1", "Forum başlığı başarıyla oluşturuldu.");
		
		response.sendRedirect("topicDetails.jsp?topicId=" + topicIdString);
	}

//	private void updateTopic(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		int topicId = Integer.parseInt(request.getParameter("topicId"));
//		String updatedTitle = request.getParameter("updatedTitle");
//
//		TopicDao topicDao = new TopicDao();
//		Topic topic = new Topic();
//		topic.setTopicId(topicId);
//		topic.setTitle(updatedTitle);
//		topicDao.updateTopic(topic);
//		topicDao.closeConnection();
//
//		request.setAttribute("message", "Forum başlığı başarıyla güncellendi.");
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
//	}

}
