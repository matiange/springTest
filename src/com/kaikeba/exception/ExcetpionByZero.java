package com.kaikeba.exception;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/25 13:08
 */
public class ExcetpionByZero extends ArithmeticException{
    public ExcetpionByZero() {
        super();
    }

    public ExcetpionByZero(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "被除数不能等于零";
    }
}
