package com.habench.cases.java_sqli_1067.web;

import com.habench.cases.java_sqli_1067.web.Step03;

public final class Step02Delegate {

    static void handle(String value) {
        Step03.apply(value);
    }
}
