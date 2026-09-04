package com.habench.cases.java_sqli_1001.dao;

import com.habench.cases.java_sqli_1001.dao.Step06;

public final class Step05Delegate {

    static void handle(String value) {
        Step06.apply(value);
    }
}
