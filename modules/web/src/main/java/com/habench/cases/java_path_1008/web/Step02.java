package com.habench.cases.java_path_1008.web;

public final class Step02 {

    public static void apply(String value) {
        Handler02 handler = select();
        handler.handle(value);
    }

    private static Handler02 select() {
        return new Handler02Impl00();
    }
}
