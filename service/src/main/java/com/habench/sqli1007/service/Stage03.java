package com.habench.sqli1007.service;

import com.habench.sqli1007.service.Stage04;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = value;
        String v302 = "order:" + v301 + ";";
        Stage04.apply(v302);
    }
}
