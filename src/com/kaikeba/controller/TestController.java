package com.kaikeba.controller;

import com.kaikeba.exception.ApplicationException;
import com.kaikeba.exception.CheckedException;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.commons.lang.xwork.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: test
 * @date 2020/7/4 23:32
 */
@Controller
@RequestMapping("/main")
public class TestController {
    @RequestMapping("/test")
    public ModelAndView test(@RequestParam Map<String,Object> param){
        ModelAndView mv = null;
        try {
            String bundle = null;
            if(param!=null && param.containsKey("code")){
                bundle = (String)param.get("code");
            }
            mv = new ModelAndView();
            if(StringUtils.isNotEmpty(bundle)){
                throw new CheckedException("file_null",bundle);
            }
            mv.addObject("index","Hello-World");
            mv.addObject("message","信息正常");
            mv.addObject("msgTitle","欢迎访问");
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("message",e.getMessage());
            mv.addObject("msgTitle","异常信息");
        } finally {
            mv.setViewName("exception");
        }
        return mv;
    }

}
