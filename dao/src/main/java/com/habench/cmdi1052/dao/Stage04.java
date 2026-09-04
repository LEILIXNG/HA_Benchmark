package com.habench.cmdi1052.dao;

import com.habench.cmdi1052.dao.SinkHandler;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        SinkHandler.execute(v401);
    }
}
