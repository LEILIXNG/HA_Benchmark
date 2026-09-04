package com.habench.cases.java_path_1000.web;

import com.habench.cases.java_path_1000.web.SinkHandler;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
