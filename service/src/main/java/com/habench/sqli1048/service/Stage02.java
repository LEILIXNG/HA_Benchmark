package com.habench.sqli1048.service;

import com.habench.sqli1048.service.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Stage03.handle(v201);
    }
}
