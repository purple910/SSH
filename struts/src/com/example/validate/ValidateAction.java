package com.example.validate;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @program: struts-02 com.example.validate
 * @description: validate
 * @author: fate
 * @create: 2019-09-20 12:07
 **/
public class ValidateAction extends ActionSupport {
    private UserEntity entity;

    public UserEntity getEntity() {
        return entity;
    }

    public void setEntity(UserEntity entity) {
        this.entity = entity;
    }

    /**
     * 默认先执行
     * @return
     * @throws Exception
     */
//    @Override
//    public void validate(){
//        if(entity.getName().length()==0){
//            System.out.println("ValidateAction.validate");
//            addFieldError("entity.name","不能为空");
//        }
//    }

    /**
     * 在执行register方法之前执行
     * @return
     * @throws Exception
     */
//    public void validateRegister(){
//        if(entity.getName().length()==0){
//            System.out.println("ValidateAction.validateRegister");
//            addFieldError("entity.name","不能为空");
//        }
//    }
    public String register() throws Exception{
        return SUCCESS;
    }

    public String excute() throws Exception{
        return SUCCESS;
    }

}
