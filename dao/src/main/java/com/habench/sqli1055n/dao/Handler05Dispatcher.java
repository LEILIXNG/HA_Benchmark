package com.habench.sqli1055n.dao;

public final class Handler05Dispatcher {

    public static void apply(String value) {
        Handler05 handler = select();
        handler.handle(value);
    }

    private static Handler05 select() {
        return new Handler05Impl00();
    }
}
