package com.habench.cmdi0002.service;

import com.habench.cmdi0002.service.Handler02Dispatcher;

public final class Stage01 {

    public static void handle(String value) {
        Handler02Dispatcher.apply(value);
    }
}
