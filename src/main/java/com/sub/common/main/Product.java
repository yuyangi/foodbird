package com.sub.common.main;

import java.lang.String;
import java.lang.Integer;

public class Product {

    /**
     * ����
     */
    private String code;

    /**
     * ����
     */
    private String name;

    /**
     * id
     */
    private Integer id;

    /**
     * �۸�
     */
    private Integer price;

    /**
     * getter for ����
     */
    public String getCode(){
        return code;
    }

    /**
     * setter for ����
     */
    public void setCode(String code){
        this.code = code;
    }

    /**
     * getter for ����
     */
    public String getName(){
        return name;
    }

    /**
     * setter for ����
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * getter for id
     */
    public Integer getId(){
        return id;
    }

    /**
     * setter for id
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * getter for �۸�
     */
    public Integer getPrice(){
        return price;
    }

    /**
     * setter for �۸�
     */
    public void setPrice(Integer price){
        this.price = price;
    }

}