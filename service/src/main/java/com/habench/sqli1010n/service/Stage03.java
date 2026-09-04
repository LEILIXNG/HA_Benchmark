package com.habench.sqli1010n.service;

import com.habench.sqli1010n.service.Sanitizer04;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        Sanitizer04.apply(v301);
    }
}
