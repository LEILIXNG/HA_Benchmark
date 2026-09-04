package com.habench.cases.java_sqli_1055.dao;

import com.habench.cases.java_sqli_1055.dao.SinkHandler;

public final class Step10Delegate {

    static void handle(String value) {
        SinkHandler.execute(value);
    }
}
