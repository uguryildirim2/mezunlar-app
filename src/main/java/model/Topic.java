package model;

import org.bson.types.ObjectId;

public class Topic {
	private ObjectId topicId;
	private String title;
	
	public ObjectId getTopicId() {
		return topicId;
	}
	public void setTopicId(ObjectId topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
