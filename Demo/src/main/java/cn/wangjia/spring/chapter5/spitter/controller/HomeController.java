package cn.wangjia.spring.chapter5.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/22
 */
@Controller
public class HomeController {

    @GetMapping("/") //处理对/home的get请求
    public String home(){
        return "home"; //视图名为home的视图
    }

}
