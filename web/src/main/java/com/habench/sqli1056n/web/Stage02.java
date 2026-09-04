package com.habench.sqli1056n.web;

import com.habench.sqli1056n.service.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Stage03.apply(v201);
    }
}
