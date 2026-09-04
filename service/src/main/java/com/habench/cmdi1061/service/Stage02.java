package com.habench.cmdi1061.service;

import com.habench.cmdi1061.dao.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Stage03.apply(v201);
    }
}
