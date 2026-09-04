package com.habench.path1013.web;

import com.habench.path1013.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        String v2 = "order:" + v1 + ";";
        Stage01.apply(v2);
    }
}
