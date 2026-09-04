package com.habench.cmdi0002.web;

import com.habench.cmdi0002.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Stage01.handle(v1);
    }
}
