package com.habench.cases.java_cmdi_1027.dao;

import com.habench.cases.java_cmdi_1027.dao.SinkHandler;

public final class Step08 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
