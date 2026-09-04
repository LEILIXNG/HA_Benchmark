package com.habench.sqli1052n.web;

import com.habench.sqli1052n.service.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Stage02.apply(v101);
    }
}
