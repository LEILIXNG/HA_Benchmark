package com.habench.cmdi1035.service;

import com.habench.cmdi1035.service.SinkHandler;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        SinkHandler.execute(v401);
    }
}
