package com.habench.cases.java_sqli_1070.service;

public final class Step08 {

    public static void apply(String value) {
        Handler08 handler = select();
        handler.handle(value);
    }

    private static Handler08 select() {
        return new Handler08Impl00();
    }
}
