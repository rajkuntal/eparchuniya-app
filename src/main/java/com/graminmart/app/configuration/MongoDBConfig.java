package com.graminmart.app.configuration;
//package com.graminmart.app.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.authentication.UserCredentials;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import com.mongodb.MongoClient;
//
//@Configuration
//@EnableMongoRepositories(basePackages="com.graminmart.app" )
//public class MongoDBConfig {
//
//	@Bean
//    public  MongoDbFactory mongoDbFactory() throws Exception {
//    	MongoClient mongoClient = new MongoClient("localhost",27017);
//    	UserCredentials userCredentials = new UserCredentials("","");
//        return new SimpleMongoDbFactory(mongoClient, "parchuniya",userCredentials);
//    }
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//        return mongoTemplate;
//    }
//}
