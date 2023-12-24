import java.util.List;

import org.bson.types.ObjectId;

import database.MessageDao;
import database.TopicDao;
import model.Message;
import model.Topic;

public class Main {

	public static void main(String[] args) {

        var message = new MessageDao();

        message.getMessagesByTopicId("6586e7c0e06cb97a7c5b0edd");
        


        // MongoDB bağlantısını kapat
        message.closeConnection();
	}
}
