package test;

import com.kaikeba.exception.ApplicationException;
import com.kaikeba.exception.CheckedException;
import com.kaikeba.exception.ExcetpionApplication;
import com.kaikeba.exception.ExcetpionByZero;
import com.kaikeba.exception.entity.MessageEnum;
import com.kaikeba.invoice.entity.Students;
import org.apache.commons.lang.xwork.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/22 20:12
 */
public class TestException {
    public static void main(String[] args) {
        Students students = null;
        if(students==null){
            throw new ExcetpionApplication(MessageEnum.CODE_110.getCode());//警告
        }

    }
}
