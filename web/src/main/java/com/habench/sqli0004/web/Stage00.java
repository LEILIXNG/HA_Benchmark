package com.habench.sqli0004.web;

import com.habench.sqli0004.web.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        String v2 = "order:" + v1 + ";";
        Stage01.handle(v2);
    }
}
