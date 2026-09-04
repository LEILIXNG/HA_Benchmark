package com.habench.cmdi1047.web;

import com.habench.cmdi1047.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = v1;
        Stage01.apply(v2);
    }
}
