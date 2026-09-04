package com.habench.cmdi1043.dao;

import com.habench.cmdi1043.dao.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        Stage03.apply(v202);
    }
}
