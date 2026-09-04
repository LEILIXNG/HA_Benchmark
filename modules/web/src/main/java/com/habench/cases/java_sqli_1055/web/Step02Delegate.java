package com.habench.cases.java_sqli_1055.web;

import com.habench.cases.java_sqli_1055.web.Step03;

public final class Step02Delegate {

    static void handle(String value) {
        Step03.apply(value);
    }
}
