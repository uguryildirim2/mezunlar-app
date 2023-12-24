package dao;

import java.util.UUID;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Database {
	private static final String MONGODB_URI = "mongodb://mongoadmin:mongoadmin@localhost:27017";
	private static final String DATABASE_NAME = "database";
	private static final String TOPICS_COLLECTION = "users";

	MongoDatabase database;

	public Database() {
		System.out.println("Database class create");
		MongoClient mongoClient = MongoClients.create(MONGODB_URI);
		this.database = mongoClient.getDatabase("database");

	}

	public void add() {
		MongoCollection<Document> collection = database.getCollection("users");
		Document doc = new Document("name", "Ramesh");
		doc.append("id", 4);
		collection.insertOne(doc);
	}

	private static MongoDatabase getConnection() {

		try {
			MongoClient mongoClient = MongoClients.create(MONGODB_URI);

			MongoDatabase database = mongoClient.getDatabase("database");
//			MongoCollection<Document> collection = database.getCollection("users");
//
//			Document doc = new Document("name", "Ramesh");
//			doc.append("id", 12);
//			collection.insertOne(doc);
			return database;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;

	}

	public static void test() {
		// TODO Auto-generated method stub

		var database = getConnection();
		MongoCollection<Document> collection = database.getCollection("users");
		Document doc = new Document("name", "Rameshss");
		doc.append("id", 12);
		collection.insertOne(doc);

	}

}
