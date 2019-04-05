package com.headius.backport9.modules.impl;

import com.headius.backport9.modules.Module;

/**
 * Created by headius on 10/18/17.
 */
public class ModuleDummy implements Module {
    public boolean isOpen(String pn) {
        return true;
    }

    public boolean isOpen(String pn, Module other) {
        return isOpen(pn);
    }

    public boolean isExported(String pn) {
        return true;
    }

    public void addOpens(String pn, Module other) {
        return;
    }
}
