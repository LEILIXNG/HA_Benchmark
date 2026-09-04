package com.habench.sqli1022.service;

import com.habench.sqli1022.service.Stage07;

public final class Stage06 {

    public static void handle(String value) {
        String v601 = "order:" + value + ";";
        Stage07.handle(v601);
    }
}
