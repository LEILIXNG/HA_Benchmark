package com.habench.cmdi1039.dao;

import com.habench.cmdi1039.dao.SinkHandler;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = "order:" + v301 + ";";
        SinkHandler.execute(v302);
    }
}
