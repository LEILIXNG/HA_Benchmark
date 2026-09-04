package com.habench.cases.java_cmdi_1027.dao;

public final class Step07 {

    public static void apply(String value) {
        Handler07 handler = select();
        handler.handle(value);
    }

    private static Handler07 select() {
        return new Handler07Impl00();
    }
}
