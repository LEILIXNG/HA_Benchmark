package com.habench.cases.java_cmdi_1067.dao;

import com.habench.cases.java_cmdi_1067.dao.SinkHandler;

public final class Step07 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
