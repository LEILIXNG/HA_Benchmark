package com.habench.sqli1023.web;

import com.habench.sqli1023.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Stage01.handle(v1);
    }
}
