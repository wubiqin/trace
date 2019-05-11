package com.wbq.log.trace;

import ch.qos.logback.classic.PatternLayout;

/**
 * @author: biqin.wu
 * @Date: 2019/5/11
 * @Time: 12:54
 * @Description:
 */
public class PatternLogBackTraceLayout extends PatternLayout {

    static {
        defaultConverterMap.put("trace_id", TraceIdPatternConverter.class.getName());
    }
}
