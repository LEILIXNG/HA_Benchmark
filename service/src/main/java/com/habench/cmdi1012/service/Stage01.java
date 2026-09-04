package com.habench.cmdi1012.service;

import com.habench.cmdi1012.dao.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = "order:" + v101 + ";";
        Stage02.handle(v102);
    }
}
