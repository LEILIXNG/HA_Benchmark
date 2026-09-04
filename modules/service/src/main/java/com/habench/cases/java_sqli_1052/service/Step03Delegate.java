package com.habench.cases.java_sqli_1052.service;

import com.habench.cases.java_sqli_1052.service.Step04;

public final class Step03Delegate {

    static void handle(String value) {
        Step04.apply(value);
    }
}
