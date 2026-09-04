package com.habench.cases.java_sqli_1042.web;

import com.habench.cases.java_sqli_1042.web.Step03;

public final class Handler02Impl00 implements Handler02 {
    @Override
    public void handle(String value) {
        Step03.apply(value);
    }
}
