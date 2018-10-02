package com.service.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;


public class ConnectionMongoDB {
	
	static DB connect;
	
	public static MongoDatabase connectNow() {
		MongoClientURI uri = new MongoClientURI("mongodb://berlot83:2911danaa@cluster0-shard-00-00-o59x4.mongodb.net:27017,cluster0-shard-00-01-o59x4.mongodb.net:27017,cluster0-shard-00-02-o59x4.mongodb.net:27017/dbpets?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("pets");
		return database;
	}
	
	public void insertTo() {
//		//DB connectToDB = connectNow();
//		MongoDatabase connectToDB = connectNow();
//		
//		MongoCollection<Document> table = connectToDB.getCollection("pets");
//		Document document = new Document();
//		//document.append("name", "value");
//		document.append("name", "hola");
//		document.append("age", 50);
//		document.append("createdDate", new Date());
//		table.insertOne(document);
	}
	
	public static void main(String[] args) {
		ConnectionMongoDB c = new ConnectionMongoDB();
		c.insertTo();
	}

}
