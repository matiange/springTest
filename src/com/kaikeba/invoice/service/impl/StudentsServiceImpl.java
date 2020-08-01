package com.kaikeba.invoice.service.impl;

import com.kaikeba.invoice.entity.Students;
import com.kaikeba.invoice.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/25 13:18
 */
@Service
public class StudentsServiceImpl implements StudentsService{

    @Override
    public List<Students> findList() {
        List<Students> list = new ArrayList<>();
        Students students1 = new Students();
        Students students2 = new Students();
        Students students3 = new Students();
        Students students4 = new Students();
        Students students5 = new Students();


        students1.setName("王小王");
        students1.setNum("20201243");
        students1.setSexy("男");
        students1.setSum(239D);
        students1.setMobilePhoneNum("15789887777");
        students1.setBankNum("62204332012200");


        students2.setName("李小莉");
        students2.setNum("20201234");
        students2.setSum(129D);
        students2.setSexy("女");
        students2.setBankNum("62304332012100");
        students2.setMobilePhoneNum("18765436654");




        students3.setName("赵晓昭");
        students3.setNum("20201245");
        students3.setSexy("男");
        students3.setSum(239D);
        students3.setMobilePhoneNum("15789887777");
        students3.setBankNum("62204332012200");


        students4.setName("周笑州");
        students4.setNum("20201236");
        students4.setSum(129D);
        students4.setSexy("女");
        students4.setBankNum("62304332012100");
        students4.setMobilePhoneNum("18765436654");

        students5.setName("郑肖争");
        students5.setNum("20201237");
        students5.setSum(129D);
        students5.setSexy("女");
        students5.setBankNum("62304332012100");
        students5.setMobilePhoneNum("18765436654");
        list.add(students1);
        list.add(students2);
        list.add(students3);
        list.add(students4);
        list.add(students5);
        return list;
    }
}
