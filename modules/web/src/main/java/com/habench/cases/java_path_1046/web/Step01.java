package com.habench.cases.java_path_1046.web;

public final class Step01 {

    public static void apply(String value) {
        Handler01 handler = select();
        handler.handle(value);
    }

    private static Handler01 select() {
        return new Handler01Impl00();
    }
}
