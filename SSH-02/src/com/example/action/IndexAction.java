package com.example.action;

import com.example.entity.BookCard;
import com.example.service.BookCardService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @program: SSH-02 com.example.action.IndexAction
 * @description:
 * @author: fate
 * @create: 2019-10-04 17:04
 **/
public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    //声明service，但不给它创建具体的实现类的实例，
    private BookCardService is = null;
    //添加set()方法
    public void setIs(BookCardService is) {
        this.is = is;
    }

    private BookCard bookCard;

    public BookCard getBookCard() {
        return bookCard;
    }

    public void setBookCard(BookCard bookCard) {
        this.bookCard = bookCard;
    }


    public String add(){
        System.out.println(bookCard);
        is.addBookCard(bookCard);
        return SUCCESS;
    }

    //编写execute()方法
    public String show() {

        //获取IndexService实例，调用getAllBookCard()方法
        //将结果保存到List集合里
        List<BookCard> myBookCardList = is.getAllBookCard();

        //将查询出来的结构集打印到控制台
        System.out.println("结果集："+myBookCardList.size());

        //获取Context上下文对象
        ActionContext ac = ActionContext.getContext();

        //将myBookCardList集合添加到上下文对象里
        ac.put("myBookCardList", myBookCardList);

        //返回一个字符串
        return "success";
    }


}
