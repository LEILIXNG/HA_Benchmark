package com.habench.sqli1061.web;

import com.habench.sqli1061.service.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        String v102 = v101;
        Stage02.handle(v102);
    }
}
