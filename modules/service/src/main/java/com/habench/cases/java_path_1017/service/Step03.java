package com.habench.cases.java_path_1017.service;

import com.habench.cases.java_path_1017.dao.Gateway04;

public final class Step03 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        Gateway04.apply(carried);
    }
}
