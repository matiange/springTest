package com.kaikeba.exception;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.NoSuchMessageException;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: 自定义异常类
 * @date 2020/7/23 22:13
 */
public class CheckedException extends RuntimeException{
    private String code;
    private String bundle="CN";

    public CheckedException() {
        super();
    }

    public CheckedException(String code,String bundle) {
        super(code);
        this.code = code;
        this.bundle = bundle;
    }

    public CheckedException(String code) {
        super(code);
        this.code = code;
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }

    protected CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getMessage(){
        if(StringUtils.isNotEmpty(this.code)){
            String i18n = null;
            try {
                i18n = "";
                Locale locale = new Locale("zh", "CN");
                if(StringUtils.isNotEmpty(this.bundle)){
                    if("US".equals(this.bundle)){
                        locale = new Locale("en", this.bundle);
                    }
                }
                ResourceBundle zhrb = ResourceBundle.getBundle("messages",locale);//找到中文的属性文件（.getBundle(文件名称,区域码)）
                i18n = zhrb.getString(this.code);//获取到异常信息
            } catch (NoSuchMessageException e) {
                return super.getMessage();
            }
            return i18n;
        }
        return super.getMessage();
    }
}
