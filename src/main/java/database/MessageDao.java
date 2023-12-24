package database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import model.Message;

public class MessageDao {
	private final MongoClient mongoClient;
	private final MongoDatabase database;

	public MessageDao() {
		this.mongoClient = MongoClients.create("mongodb://mongoadmin:mongoadmin@localhost:27017");
		this.database = mongoClient.getDatabase("forumDB");
	}

	public boolean addMessage(Message message) {
		try {
			MongoCollection<Document> messagesCollection = database.getCollection("messages");
			Document newMessage = new Document("topic_id", message.getTopicId()).append("user_id", message.getUserId())
					.append("content", message.getContent());
			messagesCollection.insertOne(newMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Message> getAllMessagesByTopic(int topicId) {
		List<Message> messages = new ArrayList<>();
		try {
			MongoCollection<Document> messagesCollection = database.getCollection("messages");
			for (Document doc : messagesCollection.find(Filters.eq("topic_id", topicId))) {
				Message message = new Message();
				message.setMessageId(doc.getInteger("_id"));
				message.setTopicId(doc.getInteger("topic_id"));
				message.setUserId(doc.getInteger("user_id"));
				message.setContent(doc.getString("content"));
				messages.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messages;
	}

	public List<Message> getMessagesByTopicId(String topicId) {
		List<Message> messages = new ArrayList<>();
		try {
			MongoCollection<Document> messagesCollection = database.getCollection("messages");
			for (Document doc : messagesCollection.find(Filters.eq("topic_id", new ObjectId(topicId)))) {
				Message message = new Message();
				message.setMessageId(doc.getObjectId("_id"));
				message.setTopicId(doc.getObjectId("topic_id"));
				message.setUserId(doc.getObjectId("user_id"));
				message.setContent(doc.getString("content"));
				messages.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messages;

	}

	public void closeConnection() {
		this.mongoClient.close();
	}

}
