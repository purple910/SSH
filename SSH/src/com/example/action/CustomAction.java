package com.example.action;

import com.example.entity.CustomEntity;
import com.example.entity.OrderEntity;
import com.example.service.CustomService;
import com.example.service.OrderService;
import com.example.service.impl.CustomServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * @program: struts-hibernate com.example.action.CustomAction
 * @description:
 * @author: fate
 * @create: 2019-10-12 14:27
 **/
public class CustomAction extends ActionSupport {

    private CustomService customService;
    private OrderService orderService;


    public CustomService getCustomService() {
        return customService;
    }

    public void setCustomService(CustomService customService) {
        this.customService = customService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private CustomEntity customEntity;
    private OrderEntity orderEntity ;
    private List list;
    private int temp = 0;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public CustomEntity getCustomEntity() {
        return customEntity;
    }

    public void setCustomEntity(CustomEntity customEntity) {
        this.customEntity = customEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }



    public String addCustom() throws IOException {
        Serializable serializable;
        if(customEntity.getId()!=0){
            serializable = customService.updateCustom(customEntity);
        }else {
            serializable = customService.addCustom(customEntity);
        }
        System.out.println("addCustom = " + serializable);
        return SUCCESS;
    }

    public String queryCustomAll(){
        if(temp==0) {
            list = customService.queryCustomAll();
            return SUCCESS;
        }else {
            if(customEntity!=null){
                 customEntity = customService.queryCustomById(this.customEntity.getId());
                 list.add(customEntity);
            }else {
                 list = customService.queryCustomAll();
            }
            return LOGIN;
        }

    }
    public String queryCustomByOrder(){
        customEntity = customService.queryCustomByOrder(orderEntity.getId());
        orderEntity = orderService.queryOrderById(this.orderEntity.getId());
        System.out.println("customEntity = " + customEntity);
        temp=2;
        return SUCCESS;
    }

    public String queryCustomInfo(){
        customEntity = customService.queryCustomById(this.customEntity.getId());
        System.out.println("customEntity = " + customEntity);
        return SUCCESS;
    }


    public String deleteCustom(){
        Serializable deleteCustom = customService.deleteCustom(customEntity);
        System.out.println("deleteCustom = " + deleteCustom);
        return SUCCESS;
    }

    public String queryOrderAll(){
        list = orderService.queryOrderAll();
        System.out.println("orderEntities = " + list);
        return SUCCESS;
    }
    public String queryOrderByCustomer(){
        list = orderService.queryOrderByCustom(customEntity);
        customEntity = customService.queryCustomById(this.customEntity.getId());
        System.out.println("orderEntities = " + list);
        temp=3;
        return SUCCESS;
    }

    public String queryOrderInfo(){
        orderEntity = orderService.queryOrderById(this.orderEntity.getId());
        System.out.println("orderEntity = " + orderEntity);
        return SUCCESS;
    }

    public String addOrder(){
        Serializable serializable;
        if(orderEntity.getId()!=0){
            serializable = orderService.updateOrder(orderEntity);
        }else {
            serializable = orderService.addOrder(orderEntity);
        }
        System.out.println("serializable = " + serializable);
        return SUCCESS;
    }

    public String deleteOrder(){
        Serializable deleteOrder = orderService.deleteOrder(orderEntity);
        System.out.println("deleteOrder = " + deleteOrder);
        return SUCCESS;
    }



}
