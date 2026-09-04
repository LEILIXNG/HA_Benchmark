package com.habench.path1002.service;

import com.habench.path1002.dao.Stage06;

public final class Stage05 {

    public static void handle(String value) {
        String v501 = "order:" + value + ";";
        String v502 = v501;
        Stage06.handle(v502);
    }
}
