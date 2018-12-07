package com.headius.backport9.platform;

public class Detect {
    public static final boolean JAVA_NINE;

    static {
        boolean j9;
        try {
            Class.forName("java.lang.Module");
            j9 = true;
        } catch (Exception e) {
            j9 = false;
        }
        JAVA_NINE = j9;
    }
}
