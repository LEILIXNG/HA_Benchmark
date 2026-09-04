package com.habench.cmdi1050n.service;

public final class Handler03Dispatcher {

    public static void apply(String value) {
        Handler03 handler = select();
        handler.handle(value);
    }

    private static Handler03 select() {
        return new Handler03Impl00();
    }
}
