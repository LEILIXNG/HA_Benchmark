package com.habench.sqli1003n.web;

public final class Handler01Dispatcher {

    public static void apply(String value) {
        Handler01 handler = select();
        handler.handle(value);
    }

    private static Handler01 select() {
        return new Handler01Impl00();
    }
}
