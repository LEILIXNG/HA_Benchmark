package com.habench.cmdi1005.service;

import com.habench.cmdi1005.service.Sanitizer03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        Sanitizer03.apply(v202);
    }
}
