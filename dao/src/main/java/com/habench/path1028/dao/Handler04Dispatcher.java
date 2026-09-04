package com.habench.path1028.dao;

public final class Handler04Dispatcher {

    public static void apply(String value) {
        Handler04 handler = select();
        handler.handle(value);
    }

    private static Handler04 select() {
        return new Handler04Impl00();
    }
}
