package com.habench.cases.java_path_1046.service;

public final class Step04 {

    public static void apply(String value) {
        Handler04 handler = select();
        handler.handle(value);
    }

    private static Handler04 select() {
        return new Handler04Impl00();
    }
}
