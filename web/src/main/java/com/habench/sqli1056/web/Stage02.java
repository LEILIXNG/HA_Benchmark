package com.habench.sqli1056.web;

import com.habench.sqli1056.service.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Stage03.apply(v201);
    }
}
