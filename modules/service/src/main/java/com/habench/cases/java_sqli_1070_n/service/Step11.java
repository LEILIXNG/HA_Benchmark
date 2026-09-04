package com.habench.cases.java_sqli_1070_n.service;

public final class Step11 {

    public static void apply(String value) {
        Handler11 handler = select();
        handler.handle(value);
    }

    private static Handler11 select() {
        return new Handler11Impl00();
    }
}
