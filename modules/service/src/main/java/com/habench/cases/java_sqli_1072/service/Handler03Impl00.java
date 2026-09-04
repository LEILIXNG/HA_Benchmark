package com.habench.cases.java_sqli_1072.service;

import com.habench.cases.java_sqli_1072.service.Step04;

public final class Handler03Impl00 implements Handler03 {
    @Override
    public void handle(String value) {
        Step04.apply(value);
    }
}
