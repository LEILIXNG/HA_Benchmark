package com.habench.cmdi1002.dao;

import com.habench.cmdi1002.dao.Stage05;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        String v402 = "order:" + v401 + ";";
        Stage05.handle(v402);
    }
}
