package com.habench.cmdi1044n.service;

import com.habench.cmdi1044n.service.Sanitizer05;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        String v402 = v401;
        Sanitizer05.apply(v402);
    }
}
