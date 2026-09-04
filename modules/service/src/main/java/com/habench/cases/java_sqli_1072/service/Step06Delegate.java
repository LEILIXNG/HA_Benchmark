package com.habench.cases.java_sqli_1072.service;

import com.habench.cases.java_sqli_1072.service.Sanitizer07;

public final class Step06Delegate {

    static void handle(String value) {
        Sanitizer07.apply(value);
    }
}
