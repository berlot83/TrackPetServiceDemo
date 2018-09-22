package com.service.dao;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.connection.Connection;

public class ConnectionMongoDB {
	
	static DB connect;
	
	public static DB connectNow() {
		MongoClient mongo = new MongoClient("localhost", 27017);
		connect = mongo.getDB("pets");
		return connect;
	}
	
	public void insertTo() {
		DB connectToDB = connectNow();
		DBCollection table = connectToDB.getCollection("pets");
		BasicDBObject document = new BasicDBObject();
		document.put("name", "mkyong");
		document.put("age", 30);
		document.put("createdDate", new Date());
		table.insert(document);
	}
	
	public static void main(String[] args) {
		ConnectionMongoDB c = new ConnectionMongoDB();
		c.insertTo();
	}

}
