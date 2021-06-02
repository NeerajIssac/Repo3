package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.Constants;
import com.mongodb.MongoClient;

@RestController
public class myController {
	
	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	Constants constants;
	
	@GetMapping("test")
	public Object testFunc() {
		constants.mongoUri();
		return (mongoClient.getDatabase("test").getCollection("collect1").find().first());
	}
	
	@GetMapping("deploy")
	public String deploy() {
		return "yeaaaaaa";
	}
}
