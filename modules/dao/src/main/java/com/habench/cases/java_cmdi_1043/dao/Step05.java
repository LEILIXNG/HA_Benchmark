package com.habench.cases.java_cmdi_1043.dao;

import com.habench.cases.java_cmdi_1043.dao.SinkHandler;

public final class Step05 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
