package com.habench.cases.java_sqli_1012_n.service;

import com.habench.cases.java_sqli_1012_n.service.Step05;

public final class Step04Delegate {

    static void handle(String value) {
        Step05.apply(value);
    }
}
