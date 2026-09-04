package com.habench.cmdi1004.dao;

import com.habench.cmdi1004.dao.Handler03Dispatcher;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = v201;
        Handler03Dispatcher.apply(v202);
    }
}
