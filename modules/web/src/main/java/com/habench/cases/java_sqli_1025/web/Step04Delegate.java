package com.habench.cases.java_sqli_1025.web;

import com.habench.cases.java_sqli_1025.web.Step05;

public final class Step04Delegate {

    static void handle(String value) {
        Step05.apply(value);
    }
}
