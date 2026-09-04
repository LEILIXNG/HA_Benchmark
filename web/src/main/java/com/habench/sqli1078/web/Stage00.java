package com.habench.sqli1078.web;

import com.habench.sqli1078.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Stage01.apply(v1);
    }
}
