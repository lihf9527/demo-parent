package com.example.repository;

import com.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository extends JpaRepository<Book, String>, QuerydslPredicateExecutor<Book> {
}
