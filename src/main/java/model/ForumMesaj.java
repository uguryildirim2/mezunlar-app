package model;

public class ForumMesaj {
	private int id;
	private int topicId;
	private String messageText;

	public ForumMesaj() {

	}

	public ForumMesaj(int topicId, String messageText) {
		this.topicId = topicId;
		this.messageText = messageText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

}
