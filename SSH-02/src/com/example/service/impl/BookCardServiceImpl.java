package com.example.service.impl;

import com.example.dao.BookCardDao;
import com.example.entity.BookCard;
import com.example.service.BookCardService;

import java.util.List;

/**
 * @program: SSH-02 com.example.service.impl.BookCardImpl
 * @description:
 * @author: fate
 * @create: 2019-10-04 17:02
 **/
public class BookCardServiceImpl implements BookCardService {
    //dao实例使用注入方式
    private BookCardDao id;
    //用于注入使用
    public void setId(BookCardDao id) {
        this.id = id;
    }
    @Override
    public List<BookCard> getAllBookCard() {
        //本类应该编写业务逻辑的代码，
        //但本例没有业务逻辑，就不用写。

        //访问数据库的代码，不会出现在service这一层
        //交给dao来操作数据库
        List<BookCard> myBookCardList = id.getAllBookCard();

        //进行其它的业务逻辑操作，比如增加多一个选项，是否过期
        //本例不需要
        //....

        return myBookCardList;
    }

    @Override
    public void addBookCard(BookCard bookCard) {
        System.out.println("BookCardServiceImpl.addBookCard");
        id.addBookCard(bookCard);
    }
}
