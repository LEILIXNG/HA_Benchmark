package com.habench.path1008.dao;

import com.habench.path1008.dao.SinkHandler;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        SinkHandler.execute(v201);
    }
}
