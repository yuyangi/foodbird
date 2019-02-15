package com.foodbird.demo.controller;

import com.foodbird.demo.datasource.Storages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/29
 */
@RequestMapping("/demo/class")
@Controller
public class StorageEndpoint {

    @ResponseBody
    @RequestMapping("/all")
    public Object allDatas() {
        return Storages.all();
    }

}
