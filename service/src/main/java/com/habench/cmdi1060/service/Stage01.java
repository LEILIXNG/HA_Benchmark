package com.habench.cmdi1060.service;

import com.habench.cmdi1060.dao.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        Stage02.handle(v101);
    }
}
