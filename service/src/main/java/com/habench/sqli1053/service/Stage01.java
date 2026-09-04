package com.habench.sqli1053.service;

import com.habench.sqli1053.service.Sanitizer02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Sanitizer02.apply(v101);
    }
}
