package com.habench.cases.java_path_1033.service;

public final class Step06 {

    public static void apply(String value) {
        Handler06 handler = select();
        handler.handle(value);
    }

    private static Handler06 select() {
        return new Handler06Impl00();
    }
}
