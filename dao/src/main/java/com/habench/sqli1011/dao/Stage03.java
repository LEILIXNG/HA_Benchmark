package com.habench.sqli1011.dao;

import com.habench.sqli1011.dao.SinkHandler;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        SinkHandler.execute(v301);
    }
}
