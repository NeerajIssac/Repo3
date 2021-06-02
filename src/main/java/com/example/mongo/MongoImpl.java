package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.constants.Constants;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoImpl {

	@Autowired
	Constants constants;

	@Bean
	public MongoClient mongoClient() {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://MyDB:dbPass@mycluster.rrsvq.mongodb.net/test?"
				+ "authSource=admin&replicaSet=atlas-1bg2im-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true");
		// System.out.println(constants.mongoUri());
		MongoClient mongoClient = new MongoClient(uri);

		return mongoClient;
	}

}
