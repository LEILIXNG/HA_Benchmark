package com.habench.cases.java_sqli_1073.dao;

import com.habench.cases.java_sqli_1073.dao.SinkHandler;

public final class Step11 {

    public static void apply(String value) {
        String carried = value;
        SinkHandler.execute(carried);
    }
}
