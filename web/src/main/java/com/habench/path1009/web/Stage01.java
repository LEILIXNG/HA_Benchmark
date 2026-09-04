package com.habench.path1009.web;

import com.habench.path1009.web.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Stage02.handle(v101);
    }
}
