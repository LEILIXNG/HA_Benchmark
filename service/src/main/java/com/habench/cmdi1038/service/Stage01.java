package com.habench.cmdi1038.service;

import com.habench.cmdi1038.service.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        Stage02.apply(v102);
    }
}
