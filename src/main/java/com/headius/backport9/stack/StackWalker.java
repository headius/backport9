package com.headius.backport9.stack;

import com.headius.backport9.platform.Detect;
import com.headius.backport9.stack.impl.StackWalker8;
import com.headius.backport9.stack.impl.StackWalker9;

import java.util.function.Function;
import java.util.stream.Stream;

public interface StackWalker {
    static StackWalker getInstance() {
        if (Detect.JAVA_NINE) {
            return getInstance9();
        } else {
            return getInstance8();
        }
    }

    static StackWalker getInstance8() {
        return new StackWalker8();
    }

    static StackWalker getInstance9() {
        return new StackWalker9();
    }

     <T> T walk(Function<? super Stream<StackFrame>, ? extends T> function);

     default <T> T walk(StackTraceElement[] trace, Function<? super Stream<StackFrame>, ? extends T> function) {
         return StackWalker8.walkElements(trace, 0, trace.length, function);
     }

    interface StackFrame {
        String getClassName();
        String getMethodName();
        Class<?> getDeclaringClass();
        int getByteCodeIndex();
        String getFileName();
        int getLineNumber();
        boolean isNativeMethod();
        StackTraceElement toStackTraceElement();
    }
}
