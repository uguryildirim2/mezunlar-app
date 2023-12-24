package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import model.ForumKonu;
import model.ForumMesaj;

public class ForumDao {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "secret";

	private static final String MONGODB_URI = "mongodb://mongoadmin:mongoadmin@localhost:27017";

	private Connection connection;
	MongoDatabase database;
	MongoCollection<Document> collection;

	public ForumDao() {
		MongoClient mongoClient = MongoClients.create(MONGODB_URI);
		this.database = mongoClient.getDatabase("database");
		this.collection = database.getCollection("users");

	}

	public static Connection getConnection() {
		Connection connection = null;
		try { // com.mysql.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "secret");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public List<ForumKonu> getAllTopics() {
		List<ForumKonu> topics = new ArrayList<>();
		Connection connection = getConnection();
//	        SELECT * FROM forum

		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM forum");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				ForumKonu topic = new ForumKonu();
				topic.setId(resultSet.getInt("id"));
				topic.setTitle(resultSet.getString("title"));
				topics.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return topics;
	}

	public List<ForumMesaj> getMessagesByTopic(int topicId) {
		List<ForumMesaj> messages = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM mesaj WHERE topic_id = ?");) {
			statement.setInt(1, topicId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					ForumMesaj message = new ForumMesaj();
					message.setId(resultSet.getInt("id"));
					message.setTopicId(resultSet.getInt("topic_id"));
					message.setMessageText(resultSet.getString("message_text"));
					messages.add(message);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messages;
	}

	public void getAllForum() {
		System.out.println("test");

		collection.find().forEach(doc -> System.out.println(doc.toJson()));

	}
}
