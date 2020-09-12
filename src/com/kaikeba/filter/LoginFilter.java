package com.kaikeba.filter;

import com.kaikeba.invoice.entity.User;
import com.kaikeba.invoice.service.UserService;
import com.kaikeba.invoice.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: 登录过滤器
 * @date 2020/9/5 21:07
 */
public class LoginFilter implements Filter {
    private static Logger logger  = LoggerFactory.getLogger(LoginFilter.class);

    private String exclusions;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if(StringUtils.isEmpty(exclusions)){
            exclusions = filterConfig.getInitParameter("exclusions");//exclusions就是web.xml中配置的排除参数(不做过滤的资源)
        }
        logger.info("=====过滤器初始化=======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String url = request.getRequestURI();
//        String servletPath = request.getServletPath();
//        String contextPath = request.getContextPath();
//        String pathInfo = request.getPathInfo();
//        StringBuffer requestURL = request.getRequestURL();


        //如果路径包含一下直接释放
        if(validateUrlInWhiteList(url)){
            filterChain.doFilter(servletRequest,servletResponse);//本过滤器释放
            return;
        }
        User user = (User) session.getAttribute("user");//获取session中的会话信息
        if(user==null){//如果user为null跳转登录,否则释放
            //获取cookie中保存的用户名：密码
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if("userCookie".equals(cookie.getName())){
                    String value = cookie.getValue();
                    if(StringUtils.isNotEmpty(value)){
                        String[] userCookie = value.split("=");
                        UserService userService = new UserServiceImpl();
                        //查询数据
                        List<User> list = userService.findList(new HashMap<String,Object>(){{
                            put("username",userCookie[0].trim());
                            put("password",userCookie[1].trim());
                        }});
                        if(list!=null && list.size()==1){
                            user = list.get(0);
                            session.setAttribute("user",list.get(0));
                            session.setMaxInactiveInterval(30);//设置失效时间,单位为s
                            break;
                        }
                    }

                }
            }

        }

        if(user==null){
            //跳转更路径+登录接口路径：
            response.sendRedirect(request.getContextPath()+"/login");
        }else{
            logger.info("=======user======{}",user);
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("=====过滤器销毁=======");
    }



    /**
     * 校验请求url是否在白名单中
     * @return
     */
    private boolean validateUrlInWhiteList(String url) {
        boolean inWhiteList = false;
        List<String> whiteList = getWhiteList();
        if (whiteList!=null) {
            for(String pattern:whiteList) {
                //pattern正则表达式：url是路径
                inWhiteList= Pattern.matches(pattern, url);
                if (inWhiteList) break;
            }
        }
        logger.info(url + " 白名单验证结果=" + inWhiteList);
        return  inWhiteList;
    }

    /**
     * @Description: 白名单
     * @author MaTianGe
     * @params
     * @return List<String>正则表达式的路径集合
     * @date 9:20 2020/9/6
     * @version 0.1
     */
    private List<String> getWhiteList() {
        List<String> whiteList = new ArrayList<>();
        whiteList.add(".*login.*");
        whiteList.add(".*doLogin.*");
        whiteList.add(".*.js");
        whiteList.add(".*/static/.*");
        whiteList.add(".*/images/.*");
        return whiteList;
    }
}
