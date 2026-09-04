package com.habench.cases.java_cmdi_1004.web;

public final class Step08 {

    public static void apply(String value) {
        Handler08 handler = select();
        handler.handle(value);
    }

    private static Handler08 select() {
        return new Handler08Impl00();
    }
}
