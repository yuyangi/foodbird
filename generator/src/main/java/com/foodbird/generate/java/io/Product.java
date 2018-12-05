package com.foodbird.generate.java.io;

import java.lang.String;
import java.lang.Integer;

public class Product {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * id
     */
    private Integer id;

    /**
     * 价格
     */
    private Integer price;

    /**
     * getter for 编码
     */
    public String getCode(){
        return code;
    }

    /**
     * setter for 编码
     */
    public void setCode(String code){
        this.code = code;
    }

    /**
     * getter for 名称
     */
    public String getName(){
        return name;
    }

    /**
     * setter for 名称
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
     * getter for 价格
     */
    public Integer getPrice(){
        return price;
    }

    /**
     * setter for 价格
     */
    public void setPrice(Integer price){
        this.price = price;
    }

}