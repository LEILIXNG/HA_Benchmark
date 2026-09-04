package com.habench.cases.java_sqli_1065.web;

import com.habench.cases.java_sqli_1065.web.Step02;

public final class Step01Delegate {

    static void handle(String value) {
        Step02.apply(value);
    }
}
