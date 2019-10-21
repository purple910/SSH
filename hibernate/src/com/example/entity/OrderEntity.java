package com.example.entity;

/**
 * @program: hibernate com.example.entity.OrderEntity
 * @description: 订单
 * @author: fate
 * @create: 2019-10-12 09:28
 **/
public class OrderEntity {
    private int id;
    private String name;
    private double price;
    private int count;

    private CustomEntity custom;

    public OrderEntity() {
    }

    public OrderEntity(int id) {
        this.id = id;
    }

    public OrderEntity(int id, String name, double price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public OrderEntity(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public OrderEntity(String name, double price, int count, CustomEntity custom) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.custom = custom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CustomEntity getCustom() {
        return custom;
    }

    public void setCustom(CustomEntity custom) {
        this.custom = custom;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
