package com.habench.cases.java_sqli_1040.web;

import com.habench.cases.java_sqli_1040.web.Step02;

public final class Handler01Impl00 implements Handler01 {
    @Override
    public void handle(String value) {
        Step02.apply(value);
    }
}
