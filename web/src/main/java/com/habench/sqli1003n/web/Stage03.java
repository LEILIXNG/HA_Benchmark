package com.habench.sqli1003n.web;

import com.habench.sqli1003n.web.Sanitizer04;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        Sanitizer04.apply(v301);
    }
}
