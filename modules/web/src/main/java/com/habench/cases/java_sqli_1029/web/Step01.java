package com.habench.cases.java_sqli_1029.web;

import com.habench.cases.java_sqli_1029.web.SinkHandler;

public final class Step01 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
