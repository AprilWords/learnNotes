package cn.wangjia.spring.chapter5.spitter.controller;

import cn.wangjia.spring.chapter5.spitter.Respositorys.Spitter;
import cn.wangjia.spring.chapter5.spitter.Respositorys.SpitterRespository;
import cn.wangjia.spring.chapter5.spitter.Respositorys.Spittle;
import cn.wangjia.spring.chapter5.spitter.Respositorys.SpittleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.validation.Valid;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/28
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRespository spitterRespository;
    @Autowired
    public SpitterController(SpitterRespository spitterRespository){
        this.spitterRespository = spitterRespository;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegisterForm(){

        return "registerForm";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return  "registerForm";
        }
        spitterRespository.save(spitter);
        return "redirct:/register/"+spitter.getUseNamme();
    }
    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String userName, Model model){
        Spitter spitter = spitterRespository.findByUserName(userName);
        model.addAttribute(spitter);
        return "profile";
    }
}
