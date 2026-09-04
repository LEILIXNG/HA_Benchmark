package com.habench.cases.java_cmdi_1019.dao;

import com.habench.cases.java_cmdi_1019.dao.SinkHandler;

public final class Step05Delegate {

    static void handle(String value) {
        SinkHandler.execute(value);
    }
}
