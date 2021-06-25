package cn.wangjia.spring.chapter5.spitter.controller;

import cn.wangjia.spring.chapter5.spitter.Respositorys.SpittleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/24
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRespository spittleRespository;
    @Autowired
    public SpittleController(SpittleRespository spittleRespository){
        this.spittleRespository = spittleRespository;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAllAttributes(spittleRespository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }

}
