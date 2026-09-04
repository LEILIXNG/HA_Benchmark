package com.habench.path1044.service;

import com.habench.path1044.dao.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Stage02.handle(v101);
    }
}
