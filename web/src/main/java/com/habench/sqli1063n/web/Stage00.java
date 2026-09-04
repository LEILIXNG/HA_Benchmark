package com.habench.sqli1063n.web;

import com.habench.sqli1063n.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Stage01.handle(v1);
    }
}
