package com.shareluntan.xuefeng.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


//过滤器
@WebFilter(filterName="LoginFilter",urlPatterns={"/"})
@Slf4j
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("loginfilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("loginfilter请求处理开始执行");

            // 设置请求编码
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            //直接传给下一个过滤器
            chain.doFilter(request, response);
            log.info("loginfilter请求处理执行完毕");

        }

    @Override
    public void destroy() {
        log.info("loginfilter 销毁");
    }
}
