package com.habench.cases.java_sqli_1044.dao;

import com.habench.cases.java_sqli_1044.dao.SinkHandler;

public final class Step05 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
