package com.habench.cases.java_sqli_1004.web;

public final class Step00 {

    public static void apply(String value) {
        Handler00 handler = select();
        handler.handle(value);
    }

    private static Handler00 select() {
        return new Handler00Impl00();
    }
}
