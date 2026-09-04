package com.habench.cases.java_path_1015.web;

import com.habench.cases.java_path_1015.service.Gateway03;

public final class Step02 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway03.apply(carried);
    }
}
