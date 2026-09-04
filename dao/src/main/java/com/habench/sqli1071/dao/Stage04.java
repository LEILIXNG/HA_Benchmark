package com.habench.sqli1071.dao;

import com.habench.sqli1071.dao.Sanitizer05;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = "order:" + value + ";";
        String v402 = "order:" + v401 + ";";
        Sanitizer05.apply(v402);
    }
}
