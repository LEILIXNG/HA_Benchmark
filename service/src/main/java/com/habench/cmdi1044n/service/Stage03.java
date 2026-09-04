package com.habench.cmdi1044n.service;

import com.habench.cmdi1044n.service.Handler04Dispatcher;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        Handler04Dispatcher.apply(v301);
    }
}
