package com.habench.cases.java_path_1002.service;

import com.habench.cases.java_path_1002.service.SinkHandler;

public final class Step04 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
