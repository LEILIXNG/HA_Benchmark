package com.habench.cases.java_sqli_0004.dao;

import com.habench.cases.java_sqli_0004.dao.SinkHandler;

public final class Step09Delegate {

    static void handle(String value) {
        SinkHandler.execute(value);
    }
}
