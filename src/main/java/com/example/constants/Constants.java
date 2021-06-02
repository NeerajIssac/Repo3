package com.example.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Constants {
	
	@Autowired
	private Environment env;
	
	public String mongoUri() {
		int cluster = Integer.parseInt(env.getProperty("mongo.cluster"));
		String uri="mongodb+srv://MyDB:";
		//System.out.println(System.getProperty("catalina.base"));
		//System.out.println(System.getProperty("user.dir"));		
		uri = uri+env.getProperty("mongo.pass")+"@";
		for(int clstr=1; clstr<= cluster; clstr++) {
			//System.out.println("mongo.cluster."+ String.valueOf(clstr));
			//System.out.println(env.getProperty("mongo.cluster."+ String.valueOf(clstr)));
			uri += env.getProperty("mongo.cluster."+ String.valueOf(clstr));
		}
		uri+="/test?authSource=admin&replicaSet=atlas-1bg2im-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";
		//System.out.println(uri);
		/**
		System.out.println(System.getProperty("catalina.base")+"/src/main/resources/application.properties");
		Properties prop = new Properties();
		String baselocation = System.getProperty("user.id");
		try (InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(System.getProperty("C:/Users/mnbv1/AppData/Local/Temp/tomcat.8080.17252893479809372073"+"/src/main/resources/application.properties"))) {
			prop.load(resourceStream);
			System.out.println(prop);
			System.out.println(prop.getProperty("mongo.cluster"));
		} catch (IOException e) {
		
			System.out.println("hereeeee");
		    e.printStackTrace();
		}
	*/
		return uri;
	}
}
