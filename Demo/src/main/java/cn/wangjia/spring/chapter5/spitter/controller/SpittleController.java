package cn.wangjia.spring.chapter5.spitter.controller;

import cn.wangjia.spring.chapter5.spitter.Respositorys.Spittle;
import cn.wangjia.spring.chapter5.spitter.Respositorys.SpittleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/24
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "11111111111111";//Long.toString(Long.MAX_VALUE);
    private SpittleRespository spittleRespository;
    @Autowired
    public SpittleController(SpittleRespository spittleRespository){
        this.spittleRespository = spittleRespository;
    }
   /* @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(spittleRespository.findSpittles(Long.MAX_VALUE,20));
        Set<String> ss = model.asMap().keySet();


        System.out.println( ss.toArray().toString());

        return "spittles";
    }*/

  /*  @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count",defaultValue = "20") int count){


        return spittleRespository.findSpittles(max,count);
    }*/
  @RequestMapping(value = "/{spittleID}",method = RequestMethod.GET)
  public  String spittles(@PathVariable("spittleID") long spitteID, Model model){

        model.addAttribute(spittleRespository.findOne(spitteID));
      return "spittles";
  }



}
