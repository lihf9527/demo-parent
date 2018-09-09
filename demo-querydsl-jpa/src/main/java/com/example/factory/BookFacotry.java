package com.example.factory;

import com.example.model.Book;
import com.example.util.RandomUtils;

public class BookFacotry {
    private static String[] names = {"西游记", "水浒传", "三国演义", "红楼梦"};
    private static String[] authors = {"吴承恩", "施耐庵", "罗贯中", "曹雪芹"};

    public static Book generateBook() {
        int i = RandomUtils.nextInt(names.length);
        Book book = new Book();
        book.setName(names[i]);
        book.setAuthor(authors[i]);
        book.setPrice(100.0);
        book.setPress("人民教育出版社");
        return book;
    }
}
