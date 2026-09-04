package com.habench.cases.java_sqli_1018.service;

import com.habench.cases.java_sqli_1018.dao.Gateway03;

public final class Step02Delegate {

    static void handle(String value) {
        Gateway03.apply(value);
    }
}
