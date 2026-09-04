package com.habench.cases.java_path_1017.web;

import com.habench.cases.java_path_1017.service.Gateway01;

public final class Step00 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway01.apply(carried);
    }
}
