package com.example.repository.mongo;

import com.example.entity.User;
import com.example.factory.UserFactory;
import com.example.result.UserBO;
import com.example.result.UserMappedResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTemplateTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertTest() {
        mongoTemplate.insert(UserFactory.getTom());
        mongoTemplate.insert(UserFactory.getJerry(), "user");
    }

    @Test
    public void insertAllTest() {
        mongoTemplate.insertAll(UserFactory.getUsers());
        mongoTemplate.insert(UserFactory.getUsers(), User.class);
        mongoTemplate.insert(UserFactory.getUsers(), "user");
    }

    @Test
    public void removeTest() {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("5bfd05952d34881d785911f6"));
        mongoTemplate.remove(query, User.class);
        mongoTemplate.remove(query, "user");
        mongoTemplate.remove(query, User.class, "user");
    }

    @Test
    public void removeAllTest() {
        mongoTemplate.remove(new Query(), User.class);
    }

    @Test
    public void findById() {
        mongoTemplate.findById("id", User.class);
        mongoTemplate.findById("id", User.class, "user");
    }

    @Test
    public void findTest() {
        mongoTemplate.find(new Query(), User.class);
        mongoTemplate.find(new Query(), User.class, "user");
    }

    @Test
    public void findAllTest() {
        mongoTemplate.findAll(User.class);
        mongoTemplate.findAll(User.class, "user");
    }

    @Test
    public void findsTest() {
        mongoTemplate.findAllAndRemove(new Query(), User.class);
        mongoTemplate.findAllAndRemove(new Query(), "user");
        mongoTemplate.findAllAndRemove(new Query(), User.class, "user");
    }

    @Test
    public void aggregateTest() {
        Aggregation aggregation = newAggregation(group("sex").count().as("num"), project("_id", "num"));
        mongoTemplate.aggregate(aggregation, User.class, UserBO.class).getMappedResults().forEach(System.out::println);
    }

    @Test
    public void mapReduceTest() {
        Iterator<UserMappedResult> iterator = mongoTemplate.mapReduce("user", "classpath:script/user/map.js", "classpath:script/user/reduce.js", UserMappedResult.class).iterator();
        iterator.forEachRemaining(System.out::println);
    }
}
