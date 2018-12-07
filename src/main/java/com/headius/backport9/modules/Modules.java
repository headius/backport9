package com.headius.backport9.modules;

import com.headius.backport9.modules.impl.Module9;
import com.headius.backport9.modules.impl.ModuleDummy;
import com.headius.backport9.platform.Detect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/**
 * Created by headius on 10/18/17.
 */
public class Modules {
    public static com.headius.backport9.modules.Module getModule(Class cls) {
        if (Detect.JAVA_NINE) {
            return new Module9(cls.getModule());
        }
        return new ModuleDummy();
    }

    public static <T extends AccessibleObject & Member> boolean trySetAccessible(T accessibleMember) {
        return trySetAccessible(accessibleMember.getDeclaringClass(), accessibleMember);
    }

    private static boolean trySetAccessible(Class<?> declaringClass, AccessibleObject accessibleObject) {
        if (accessibleObject.isAccessible()) return true;

        com.headius.backport9.modules.Module module = getModule(declaringClass);

        try {
            if (module.isOpen(declaringClass.getPackage().getName())) {
                accessibleObject.setAccessible(true);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
