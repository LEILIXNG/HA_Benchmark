package com.habench.cases.java_sqli_1025.web;

public final class Step03 {

    public static void apply(String value) {
        Handler03 handler = select();
        handler.handle(value);
    }

    private static Handler03 select() {
        return new Handler03Impl00();
    }
}
