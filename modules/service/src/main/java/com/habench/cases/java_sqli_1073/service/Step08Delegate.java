package com.habench.cases.java_sqli_1073.service;

import com.habench.cases.java_sqli_1073.dao.Gateway09;

public final class Step08Delegate {

    static void handle(String value) {
        Gateway09.apply(value);
    }
}
