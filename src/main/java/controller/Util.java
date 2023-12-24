package controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.Database;
import dao.ForumDao;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var forumDao = new ForumDao();
		forumDao.getAllForum();
		

	}

}
