package com.habench.cmdi1059.web;

import com.habench.cmdi1059.web.Handler01Dispatcher;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        String v2 = "order:" + v1 + ";";
        Handler01Dispatcher.apply(v2);
    }
}
