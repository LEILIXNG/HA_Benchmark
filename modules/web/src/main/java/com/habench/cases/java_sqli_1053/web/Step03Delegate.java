package com.habench.cases.java_sqli_1053.web;

import com.habench.cases.java_sqli_1053.web.Step04;

public final class Step03Delegate {

    static void handle(String value) {
        Step04.apply(value);
    }
}
