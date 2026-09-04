package com.habench.path1006.service;

import com.habench.path1006.dao.Stage05;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = value;
        String v402 = "order:" + v401 + ";";
        Stage05.apply(v402);
    }
}
