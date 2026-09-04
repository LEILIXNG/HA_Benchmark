package com.habench.cases.java_path_1023.web;

import com.habench.cases.java_path_1023.web.Step04;

public final class Step03 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step04.apply(carried);
    }
}
