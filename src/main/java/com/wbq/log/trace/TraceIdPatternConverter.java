package com.wbq.log.trace;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.wbq.log.trace.intercept.TraceInterceptor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

/**
 * @author: biqin.wu
 * @Date: 2019/5/11
 * @Time: 13:35
 * @Description:
 */
public class TraceIdPatternConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        String traceId = TraceInterceptor.getTraceId();
        return StringUtils.isEmpty(traceId) ? Strings.EMPTY : traceId;
    }
}
