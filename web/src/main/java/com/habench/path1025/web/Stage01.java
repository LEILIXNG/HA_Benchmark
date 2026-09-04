package com.habench.path1025.web;

import com.habench.path1025.web.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = "order:" + v101 + ";";
        Stage02.apply(v102);
    }
}
