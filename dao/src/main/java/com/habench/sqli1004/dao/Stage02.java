package com.habench.sqli1004.dao;

import com.habench.sqli1004.dao.Sanitizer03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Sanitizer03.apply(v201);
    }
}
