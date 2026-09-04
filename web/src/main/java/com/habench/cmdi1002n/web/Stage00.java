package com.habench.cmdi1002n.web;

import com.habench.cmdi1002n.web.Handler01Dispatcher;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        Handler01Dispatcher.apply(v1);
    }
}
