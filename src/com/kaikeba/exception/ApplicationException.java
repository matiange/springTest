package com.kaikeba.exception;

import com.kaikeba.exception.entity.MessageEnum;
import com.sun.javafx.binding.StringFormatter;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/22 19:57
 */
public class ApplicationException extends RuntimeException{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ApplicationException(String code) {
        super(code);
        this.code=code;
    }

    public ApplicationException(String code, Throwable cause) {
        super(code, cause);
        this.code=code;
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    protected ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @Description: 重写获取异常信息
     * @author MaTianGe
     * @params
     * @return
     * @date 20:21 2020/7/22
     * @version 0.1
     */
    @Override
    public String getMessage() {
        if(this.code!=null && this.code.length()>0){
            if(MessageEnum.CODE_110.getCode().equals(this.code)){
                return MessageEnum.CODE_110.getMessage();
            }

            if(MessageEnum.CODE_120.getCode().equals(this.code)){
                return MessageEnum.CODE_120.getMessage();
            }

            return String.format("未指定的异常编码%s",code);
        }
        return super.getMessage();
    }
}
