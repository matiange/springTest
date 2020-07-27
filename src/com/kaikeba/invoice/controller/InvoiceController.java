package com.kaikeba.invoice.controller;

import com.kaikeba.invoice.entity.Students;
import com.kaikeba.invoice.service.StudentsService;
import com.kaikeba.invoice.service.impl.StudentsServiceImpl;
import com.kaikeba.tools.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/18 11:37
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    /*@Autowired
    StudentsService studentsService;*/

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        StudentsService studentsService = new StudentsServiceImpl();// list<Students> findListStudents()
        List<Students> list = studentsService.findList();
        mv.addObject("lists",list);
        mv.addObject("message","发票管理");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(HttpServletResponse response) throws Exception {
        List<Students> list = new ArrayList<>();
        Students students1 = new Students();
        Students students2 = new Students();
        students1.setName("王小王");
        students1.setNum("20201244");
        students1.setSum(239D);
        students2.setName("李小莉");
        students2.setNum("20201233");
        students2.setSum(129D);
        list.add(students1);
        list.add(students2);
//        Response.write(response,list.toString());
        return list.toString();
    }
}
