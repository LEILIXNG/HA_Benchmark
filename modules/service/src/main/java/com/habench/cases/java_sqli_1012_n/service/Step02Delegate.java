package com.habench.cases.java_sqli_1012_n.service;

import com.habench.cases.java_sqli_1012_n.service.Step03;

public final class Step02Delegate {

    static void handle(String value) {
        Step03.apply(value);
    }
}
