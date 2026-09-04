package com.habench.cmdi1001.dao;

import com.habench.cmdi1001.dao.SinkHandler;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        SinkHandler.execute(v401);
    }
}
