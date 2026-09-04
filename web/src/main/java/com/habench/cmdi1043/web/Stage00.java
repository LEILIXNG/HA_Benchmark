package com.habench.cmdi1043.web;

import com.habench.cmdi1043.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Stage01.handle(v1);
    }
}
