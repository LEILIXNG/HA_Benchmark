package com.habench.cases.java_sqli_1022.web;

public final class Step05 {

    public static void apply(String value) {
        Handler05 handler = select();
        handler.handle(value);
    }

    private static Handler05 select() {
        return new Handler05Impl00();
    }
}
