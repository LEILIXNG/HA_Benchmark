package com.habench.cases.java_path_1042.web;

import com.habench.cases.java_path_1042.web.Step01;

public final class Step00 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step01.apply(carried);
    }
}
