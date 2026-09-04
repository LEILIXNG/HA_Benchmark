package com.habench.cmdi1050.service;

import com.habench.cmdi1050.service.SinkHandler;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = value;
        String v302 = "order:" + v301 + ";";
        SinkHandler.execute(v302);
    }
}
