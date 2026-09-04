package com.habench.cmdi1042.web;

import com.habench.cmdi1042.web.Handler01Dispatcher;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        Handler01Dispatcher.apply(v1);
    }
}
