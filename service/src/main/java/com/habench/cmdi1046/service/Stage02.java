package com.habench.cmdi1046.service;

import com.habench.cmdi1046.dao.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Stage03.handle(v201);
    }
}
