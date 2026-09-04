package com.habench.cases.java_sqli_1004.web;

import com.habench.cases.java_sqli_1004.service.Gateway04;

public final class Handler03Impl00 implements Handler03 {
    @Override
    public void handle(String value) {
        Gateway04.apply(value);
    }
}
