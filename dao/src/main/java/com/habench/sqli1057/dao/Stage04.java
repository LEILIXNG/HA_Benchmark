package com.habench.sqli1057.dao;

import com.habench.sqli1057.dao.SinkHandler;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        String v402 = "order:" + v401 + ";";
        SinkHandler.execute(v402);
    }
}
