package com.habench.cmdi1035.service;

public final class Handler02Dispatcher {

    public static void apply(String value) {
        Handler02 handler = select();
        handler.handle(value);
    }

    private static Handler02 select() {
        return new Handler02Impl00();
    }
}
