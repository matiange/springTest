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
/*@Service*/
public class StudentsServiceImpl implements StudentsService{

    @Override
    public List<Students> findList() {
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
        return list;
    }
}
