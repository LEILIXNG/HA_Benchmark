package com.habench.cases.java_sqli_1010.web;

import com.habench.cases.java_sqli_1010.web.Step02;

public final class Step01Delegate {

    static void handle(String value) {
        Step02.apply(value);
    }
}
