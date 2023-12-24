package database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import model.User;

public class UserDao {
	 private final MongoClient mongoClient;
	    private final MongoDatabase database;

	    public UserDao() {
			this.mongoClient = MongoClients.create("mongodb://mongoadmin:mongoadmin@localhost:27017");
	        this.database = mongoClient.getDatabase("forumDB");
	    }

	    public boolean addUser(User user) {
	        try {
	            MongoCollection<Document> usersCollection = database.getCollection("users");
	            Document newUser = new Document("username", user.getUsername())
	                    .append("password", user.getPassword());
	            usersCollection.insertOne(newUser);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public User getUserByUsernameAndPassword(String username, String password) {
	        try {
	            MongoCollection<Document> usersCollection = database.getCollection("users");
	            Document doc = usersCollection.find(Filters.and(Filters.eq("username", username), Filters.eq("password", password))).first();
	            if (doc != null) {
	                User user = new User();
	                user.setUsername(doc.getString("username"));
	                user.setPassword(doc.getString("password"));
	                return user;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	    public List<User> getAllUsers() {
	        List<User> users = new ArrayList<>();
	        try {
	            MongoCollection<Document> usersCollection = database.getCollection("users");
	            for (Document doc : usersCollection.find()) {
	                User user = new User();
	                user.setUserId(doc.getObjectId("_id"));
	                user.setUsername(doc.getString("username"));
	                user.setPassword(doc.getString("password"));
	                users.add(user);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    // Diğer CRUD metotları eklenebilir

	    public void closeConnection() {
	        this.mongoClient.close();
	    }
}
