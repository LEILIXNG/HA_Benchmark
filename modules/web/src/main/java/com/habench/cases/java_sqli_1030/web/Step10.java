package com.habench.cases.java_sqli_1030.web;

public final class Step10 {

    public static void apply(String value) {
        Handler10 handler = select();
        handler.handle(value);
    }

    private static Handler10 select() {
        return new Handler10Impl00();
    }
}
