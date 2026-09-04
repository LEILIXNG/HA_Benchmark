package com.habench.cmdi1055.dao;

import com.habench.cmdi1055.dao.Sanitizer03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Sanitizer03.apply(v201);
    }
}
