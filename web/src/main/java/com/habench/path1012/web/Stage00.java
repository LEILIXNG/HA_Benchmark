package com.habench.path1012.web;

import com.habench.path1012.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Stage01.handle(v1);
    }
}
