package com.example.mapper;

import com.example.model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> findAll();

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(String id);

    @Delete("DELETE FROM book WHERE id = #{id}")
    int deleteById(String id);
}
