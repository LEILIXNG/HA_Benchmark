package com.habench.path1002.web;

import com.habench.path1002.service.Stage05;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = value;
        String v402 = "order:" + v401 + ";";
        Stage05.handle(v402);
    }
}
