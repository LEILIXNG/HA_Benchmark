package com.habench.path1020.dao;

import com.habench.path1020.dao.Handler04Dispatcher;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = value;
        String v302 = "order:" + v301 + ";";
        Handler04Dispatcher.apply(v302);
    }
}
