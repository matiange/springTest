package com.kaikeba.tools;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/18 12:39
 */
public class Response {
    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
