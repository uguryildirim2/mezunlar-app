package model;

import org.bson.types.ObjectId;

public class Message {
	private ObjectId messageId;
	private ObjectId topicId;
	private ObjectId userId;
	private String content;
	
	public ObjectId getMessageId() {
		return messageId;
	}
	public void setMessageId(ObjectId messageId) {
		this.messageId = messageId;
	}
	public ObjectId getTopicId() {
		return topicId;
	}
	public void setTopicId(ObjectId topicId) {
		this.topicId = topicId;
	}
	public ObjectId getUserId() {
		return userId;
	}
	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
