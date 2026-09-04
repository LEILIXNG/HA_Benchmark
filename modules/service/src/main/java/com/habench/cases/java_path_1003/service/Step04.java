package com.habench.cases.java_path_1003.service;

import com.habench.cases.java_path_1003.service.Step05;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step05.apply(carried);
    }
}
