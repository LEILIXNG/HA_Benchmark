package com.habench.cmdi1028.web;

import com.habench.cmdi1028.web.Sanitizer02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Sanitizer02.apply(v101);
    }
}
