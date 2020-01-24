package com.example.service;

import com.example.entity.BookCard;

import java.util.List;

/**
 * @program: SSH-02 com.example.service.BookCardService
 * @description:
 * @author: fate
 * @create: 2019-10-04 17:02
 **/
public interface BookCardService {
    public List<BookCard> getAllBookCard();
    public void addBookCard(BookCard bookCard);
}
