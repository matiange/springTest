package com.kaikeba.invoice.service;

import com.kaikeba.invoice.entity.Students;

import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/25 13:16
 */
public interface StudentsService {
    /**
     * @Description: 查询学生
     * @author MaTianGe
     * @params List<Students>
     * @return
     * @date 16:54 2020/7/25
     * @version 0.1
     */
    List<Students> findList();
}
