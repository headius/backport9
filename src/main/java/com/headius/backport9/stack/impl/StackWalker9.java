package com.headius.backport9.stack.impl;

import com.headius.backport9.stack.StackWalker;

import java.util.function.Function;
import java.util.stream.Stream;

public class StackWalker9 implements StackWalker {
    private final java.lang.StackWalker walker;

    public StackWalker9() {
        walker = java.lang.StackWalker.getInstance();
    }

    @Override
    public <T> T walk(Function<? super Stream<StackFrame>, ? extends T> function) {
        // start at 1 to remove this frame from the walk
        return walker.walk(stream -> function.apply(stream.skip(1).map(frame -> new StackFrame9(frame))));
    }

    private static class StackFrame9 implements StackFrame {
        final java.lang.StackWalker.StackFrame frame;

        StackFrame9(java.lang.StackWalker.StackFrame frame) {
            this.frame = frame;
        }

        @Override
        public String getClassName() {
            return frame.getClassName();
        }

        @Override
        public String getMethodName() {
            return frame.getMethodName();
        }

        @Override
        public Class<?> getDeclaringClass() {
            return null;
        }

        @Override
        public int getByteCodeIndex() {
            return -1;
        }

        @Override
        public String getFileName() {
            return frame.getFileName();
        }

        @Override
        public int getLineNumber() {
            return frame.getLineNumber();
        }

        @Override
        public boolean isNativeMethod() {
            return frame.isNativeMethod();
        }

        @Override
        public StackTraceElement toStackTraceElement() {
            return frame.toStackTraceElement();
        }
    }
}
