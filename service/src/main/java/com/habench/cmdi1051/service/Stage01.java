package com.habench.cmdi1051.service;

import com.habench.cmdi1051.dao.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        String v102 = "order:" + v101 + ";";
        Stage02.handle(v102);
    }
}
