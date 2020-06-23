package com.headius.backport9.modules;

import java.lang.reflect.Method;

public interface Module {
    boolean isOpen(String pn);
    boolean isOpen(String pn, Module other);
    boolean isExported(String pn);
    boolean isExported(String pn, Module other);
    boolean isNamed();
    void addOpens(String pn, Module other);
    String getName();
}
