package com.habench.path1004.web;

import com.habench.path1004.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = v1;
        Stage01.handle(v2);
    }
}
