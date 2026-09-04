package com.habench.cmdi1062.service;

import com.habench.cmdi1062.service.Handler02Dispatcher;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        Handler02Dispatcher.apply(v102);
    }
}
