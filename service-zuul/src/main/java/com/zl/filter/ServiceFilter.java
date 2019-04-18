package com.zl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ServiceFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(ServiceFilter.class);

    /**
     * 过滤器类型选择：
     * pre 为路由前
     * route 为路由过程中
     * post 为路由过程后
     * error 为出现错误的时候
     * 同时也支持static ，返回静态的响应，详情见StaticResponseFilter的实现
     * 以上类型在会创建或添加或运行在FilterProcessor.runFilters(type)
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 用来过滤器排序执行的
     * @return 排序的序号
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 是否通过这个过滤器，默认为true，改成false则不启用
     */
    @Override
    public boolean shouldFilter() {
        return true;//返回true表示执行这个过滤器
    }
    /**
     * 过滤器的逻辑
     */
    public Object run() {
        RequestContext rct=RequestContext.getCurrentContext();
        HttpServletRequest request=rct.getRequest();
        logger.info("进入访问过滤器 ,请求的地址:{},访问的方法:{}",request.getRequestURI(),request.getMethod());
        //随便传入一个参数当过滤条件
        String key=request.getParameter("sys");
        //判断这个值存不存在
        if(StringUtils.isEmpty(key)){
            logger.info("当前请求没有sys");
            rct.setSendZuulResponse(false);
            rct.setResponseStatusCode(401);
            return null;
        }
        logger.info("请求通过过滤器");
        return null;
    }
}
