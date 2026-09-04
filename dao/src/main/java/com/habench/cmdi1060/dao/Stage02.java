package com.habench.cmdi1060.dao;

import com.habench.cmdi1060.dao.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        Stage03.handle(v202);
    }
}
