package com.habench.cases.java_sqli_1012.service;

import com.habench.cases.java_sqli_1012.service.Step05;

public final class Step04Delegate {

    static void handle(String value) {
        Step05.apply(value);
    }
}
