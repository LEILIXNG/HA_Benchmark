package com.habench.cases.java_sqli_1016.web;

import com.habench.cases.java_sqli_1016.service.Gateway03;

public final class Step02Delegate {

    static void handle(String value) {
        Gateway03.apply(value);
    }
}
