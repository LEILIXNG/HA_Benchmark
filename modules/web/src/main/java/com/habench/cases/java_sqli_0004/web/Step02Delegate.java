package com.habench.cases.java_sqli_0004.web;

import com.habench.cases.java_sqli_0004.service.Gateway03;

public final class Step02Delegate {

    static void handle(String value) {
        Gateway03.apply(value);
    }
}
