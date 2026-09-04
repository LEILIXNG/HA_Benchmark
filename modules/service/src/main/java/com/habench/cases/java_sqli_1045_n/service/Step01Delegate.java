package com.habench.cases.java_sqli_1045_n.service;

import com.habench.cases.java_sqli_1045_n.service.Sanitizer02;

public final class Step01Delegate {

    static void handle(String value) {
        Sanitizer02.apply(value);
    }
}
