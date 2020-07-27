package com.kaikeba.exception;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/22 19:53
 */
public interface MesBizException {
    String getCode();

    String[] getParams();
}
