package com.habench.path1043.service;

public final class Handler06Dispatcher {

    public static void apply(String value) {
        Handler06 handler = select();
        handler.handle(value);
    }

    private static Handler06 select() {
        return new Handler06Impl00();
    }
}
