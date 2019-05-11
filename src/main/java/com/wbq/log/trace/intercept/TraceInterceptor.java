package com.wbq.log.trace.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

/**
 * @author: biqin.wu
 * @Date: 2019/5/11
 * @Time: 12:56
 * @Description:
 */
public class TraceInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<String> TRACE_THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String traceId = Optional.ofNullable(request.getHeader("trace_id")).orElse(UUID.randomUUID().toString());
        TRACE_THREAD_LOCAL.set(traceId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        remove();
    }

    public static String getTraceId() {
        return TRACE_THREAD_LOCAL.get();
    }

    public void setTraceId(String traceId) {
        TRACE_THREAD_LOCAL.set(traceId);
    }

    private void remove() {
        TRACE_THREAD_LOCAL.remove();
    }

}
