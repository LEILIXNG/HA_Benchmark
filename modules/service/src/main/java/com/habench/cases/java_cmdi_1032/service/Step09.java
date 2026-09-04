package com.habench.cases.java_cmdi_1032.service;

public final class Step09 {

    public static void apply(String value) {
        Handler09 handler = select();
        handler.handle(value);
    }

    private static Handler09 select() {
        return new Handler09Impl00();
    }
}
