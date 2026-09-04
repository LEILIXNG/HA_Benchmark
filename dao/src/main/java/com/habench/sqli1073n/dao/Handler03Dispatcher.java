package com.habench.sqli1073n.dao;

public final class Handler03Dispatcher {

    public static void apply(String value) {
        Handler03 handler = select();
        handler.handle(value);
    }

    private static Handler03 select() {
        return new Handler03Impl00();
    }
}
