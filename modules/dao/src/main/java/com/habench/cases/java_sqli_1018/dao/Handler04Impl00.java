package com.habench.cases.java_sqli_1018.dao;

import com.habench.cases.java_sqli_1018.dao.Step05;

public final class Handler04Impl00 implements Handler04 {
    @Override
    public void handle(String value) {
        Step05.apply(value);
    }
}
