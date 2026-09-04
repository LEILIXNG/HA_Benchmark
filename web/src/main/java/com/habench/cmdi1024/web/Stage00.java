package com.habench.cmdi1024.web;

import com.habench.cmdi1024.service.Stage01;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = value;
        Stage01.apply(v1);
    }
}
