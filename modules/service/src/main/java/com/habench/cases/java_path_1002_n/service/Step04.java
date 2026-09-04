package com.habench.cases.java_path_1002_n.service;

import com.habench.cases.java_path_1002_n.service.Sanitizer05;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Sanitizer05.apply(carried);
    }
}
