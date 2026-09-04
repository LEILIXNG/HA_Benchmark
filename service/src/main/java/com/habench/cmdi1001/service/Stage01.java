package com.habench.cmdi1001.service;

import com.habench.cmdi1001.service.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Stage02.apply(v101);
    }
}
