package com.habench.cases.java_sqli_1034.dao;

import com.habench.cases.java_sqli_1034.dao.SinkHandler;

public final class Step05 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
