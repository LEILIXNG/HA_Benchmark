package com.habench.cmdi1050.web;

import com.habench.cmdi1050.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        Stage01.apply(v2);
    }
}
