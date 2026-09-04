package com.habench.cmdi1051n.service;

import com.habench.cmdi1051n.dao.Sanitizer02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        String v102 = "order:" + v101 + ";";
        Sanitizer02.apply(v102);
    }
}
