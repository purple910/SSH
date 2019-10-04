package com.example.dao;

import com.example.entity.BookCard;

import java.util.List;

/**
 * @program: SSH-02 com.example.dao.BookCardDao
 * @description:
 * @author: fate
 * @create: 2019-10-04 16:55
 **/
public interface BookCardDao {
    public List<BookCard> getAllBookCard();
    public void addBookCard(BookCard bookCard);
}
