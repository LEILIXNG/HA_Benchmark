package com.habench.cases.java_cmdi_1060.dao;

public final class Step06 {

    public static void apply(String value) {
        Handler06 handler = select();
        handler.handle(value);
    }

    private static Handler06 select() {
        return new Handler06Impl00();
    }
}
