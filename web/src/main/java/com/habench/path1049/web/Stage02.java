package com.habench.path1049.web;

import com.habench.path1049.service.Stage03;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = "order:" + v201 + ";";
        Stage03.handle(v202);
    }
}
