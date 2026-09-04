package com.habench.cases.java_path_1029_n.web;

import com.habench.cases.java_path_1029_n.web.Step03;

public final class Step02 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Step03.apply(carried);
    }
}
