package com.habench.path1049.service;

import com.habench.path1049.service.SinkHandler;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = value;
        String v302 = "order:" + v301 + ";";
        SinkHandler.execute(v302);
    }
}
