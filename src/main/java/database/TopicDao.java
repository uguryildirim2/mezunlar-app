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

import model.Topic;

public class TopicDao {
	private final MongoClient mongoClient;
	private final MongoDatabase database;

	public TopicDao() {
		this.mongoClient = MongoClients.create("mongodb://mongoadmin:mongoadmin@localhost:27017");
		this.database = mongoClient.getDatabase("forumDB");
	}

	public void addTopic(Topic topic) {
		try {
			MongoCollection<Document> topicsCollection = database.getCollection("topics");
			Document newTopic = new Document("title", topic.getTitle());
			topicsCollection.insertOne(newTopic);
//	            return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
//	        return false;
	}

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		try {
			MongoCollection<Document> topicsCollection = database.getCollection("topics");
			for (Document doc : topicsCollection.find()) {
				Topic topic = new Topic();
				topic.setTopicId(doc.getObjectId("_id"));
				topic.setTitle(doc.getString("title"));
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}

	public Topic getTopicById(String topicId) {
		try {
			MongoCollection<Document> topicsCollection = database.getCollection("topics");
			Document doc = topicsCollection.find(Filters.eq("_id", new ObjectId(topicId))).first();
			if (doc != null) {
				Topic topic = new Topic();
				topic.setTopicId(doc.getObjectId("_id"));
				topic.setTitle(doc.getString("title"));
				return topic;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection() {
		this.mongoClient.close();
	}

}
