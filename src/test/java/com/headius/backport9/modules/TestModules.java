package com.headius.backport9.modules;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestModules {
    @Test
    public void testModulesIsOpen() {
        // This class
        assertTrue(Modules.isOpen(TestModules.class, TestModules.class));
    }

    @Test
    public void testModuleGetName() {
        assertEquals(System.class.getModule().getName(), Modules.getModule(System.class).getName());
    }
}
