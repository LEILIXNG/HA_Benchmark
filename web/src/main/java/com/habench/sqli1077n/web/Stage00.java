package com.habench.sqli1077n.web;

import com.habench.sqli1077n.web.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = v1;
        Stage01.handle(v2);
    }
}
