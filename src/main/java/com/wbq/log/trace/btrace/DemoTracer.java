package com.wbq.log.trace.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * @author: biqin.wu
 * @Date: 2019/5/20
 */
@BTrace
public class DemoTracer {

    @OnMethod(clazz = "com.wbq.log.trace.btrace.BtraceDemo", method = "cal", location = @Location(Kind.RETURN))
    public static void lalala(@Return int result) {
        println("trace-------------");
        println(strcat("result:", str(result)));
        jstack();
    }

    @OnMethod(clazz = "com.wbq.log.trace.btrace.BtraceDemo", method = "exception", location = @Location(Kind.ERROR))
    public static void lalala1(Throwable throwable, @Duration long duration) {
        println("exception trace-------------");
        println(BTraceUtils.jstackStr(throwable));
        jstack();
    }

    @OnMethod(clazz = "java.lang.Thread", method = "start")
    public static void onThreadStart() {
        println("tracing method start");
    }
}
