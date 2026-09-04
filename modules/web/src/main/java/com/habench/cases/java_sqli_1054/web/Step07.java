package com.habench.cases.java_sqli_1054.web;

import com.habench.cases.java_sqli_1054.web.SinkHandler;

public final class Step07 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
