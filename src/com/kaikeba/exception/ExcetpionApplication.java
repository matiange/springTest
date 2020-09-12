package com.kaikeba.exception;

import com.kaikeba.exception.entity.MessageEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/25 16:30
 */
public class ExcetpionApplication extends RuntimeException{
    private String msgCode;

    public ExcetpionApplication() {
        super();
    }

    public ExcetpionApplication(String message) {
        super(message);
        this.msgCode = message;
    }

    public ExcetpionApplication(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcetpionApplication(Throwable cause) {
        super(cause);
    }

    protected ExcetpionApplication(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        if(StringUtils.isNotEmpty(this.msgCode)){
            if(MessageEnum.CODE_110.getCode().equals(this.msgCode)){
                return MessageEnum.CODE_110.getMessage();
            }
            if(MessageEnum.CODE_120.getCode().equals(this.msgCode)){
                return MessageEnum.CODE_120.getMessage();
            }
        }
        return super.getMessage();
    }
}
