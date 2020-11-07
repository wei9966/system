package com.qs.insurance.system.common.gateway.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jhy
 * @date 2020/5/5 15:59
 */
// @Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
//        if(req.getRealPath().toString().indexOf("ws") > 0){
//            chain.doFilter(req, res);
//            return;
//        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");//POST, GET, PUT, OPTIONS, DELETE, PATCH
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");//Origin, X-Requested-With, Content-Type, Accept
        response.setHeader("Access-Control-Expose-Headers", "Location");
        response.setHeader("Access-Control-Allow-Credentials", "false");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}
