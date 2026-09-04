package com.habench.cmdi1019n.service;

import com.habench.cmdi1019n.service.SinkHandler;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        String v402 = "order:" + v401 + ";";
        SinkHandler.execute(v402);
    }
}
