package com.habench.sqli1037.service;

import com.habench.sqli1037.dao.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = v201;
        Stage03.handle(v202);
    }
}
