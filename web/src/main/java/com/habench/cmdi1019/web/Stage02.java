package com.habench.cmdi1019.web;

import com.habench.cmdi1019.web.Handler03Dispatcher;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        Handler03Dispatcher.apply(v202);
    }
}
