package com.habench.cases.java_path_1019.dao;

import com.habench.cases.java_path_1019.dao.SinkHandler;

public final class Step03 {

    public static void apply(String value) {
        String carried = "order:" + value + ";";
        SinkHandler.execute(carried);
    }
}
