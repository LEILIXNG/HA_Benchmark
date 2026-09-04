package com.habench.sqli1040.web;

import com.habench.sqli1040.service.Stage04;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = "order:" + v301 + ";";
        Stage04.handle(v302);
    }
}
