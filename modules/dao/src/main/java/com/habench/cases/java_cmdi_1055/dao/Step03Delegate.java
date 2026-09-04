package com.habench.cases.java_cmdi_1055.dao;

import com.habench.cases.java_cmdi_1055.dao.SinkHandler;

public final class Step03Delegate {

    static void handle(String value) {
        SinkHandler.execute(value);
    }
}
