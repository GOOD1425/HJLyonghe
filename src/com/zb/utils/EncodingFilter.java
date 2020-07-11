package com.zb.utils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-8 15:33
 * @description:
 */
//实现filter接口
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // System.out.println("初始过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
     //   System.out.println("过滤器准备就绪");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

        //System.out.println("过滤器销毁");
    }
}
