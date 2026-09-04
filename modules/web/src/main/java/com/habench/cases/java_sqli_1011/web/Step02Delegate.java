package com.habench.cases.java_sqli_1011.web;

import com.habench.cases.java_sqli_1011.service.Gateway03;

public final class Step02Delegate {

    static void handle(String value) {
        Gateway03.apply(value);
    }
}
