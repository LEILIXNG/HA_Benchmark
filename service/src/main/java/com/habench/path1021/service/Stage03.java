package com.habench.path1021.service;

import com.habench.path1021.service.Sanitizer04;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = v301;
        Sanitizer04.apply(v302);
    }
}
