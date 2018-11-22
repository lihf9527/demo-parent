package com.example.repository.querydsl;

import com.example.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends QuerydslPredicateExecutor<User> {
}
