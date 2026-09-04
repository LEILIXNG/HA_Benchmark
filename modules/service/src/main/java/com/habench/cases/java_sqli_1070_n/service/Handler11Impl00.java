package com.habench.cases.java_sqli_1070_n.service;

import com.habench.cases.java_sqli_1070_n.service.Sanitizer12;

public final class Handler11Impl00 implements Handler11 {
    @Override
    public void handle(String value) {
        Sanitizer12.apply(value);
    }
}
