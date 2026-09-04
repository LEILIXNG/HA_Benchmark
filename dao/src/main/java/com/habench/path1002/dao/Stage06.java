package com.habench.path1002.dao;

import com.habench.path1002.dao.SinkHandler;

public final class Stage06 {
    private static String cached;

    public static void handle(String value) {
        String v601 = "order:" + value + ";";
        cached = v601;
        stage1();
    }

    private static void stage1() {
        String v602 = cached;
        String v603 = "order:" + v602 + ";";
        String v604 = v603;
        SinkHandler.execute(v604);
    }
}
