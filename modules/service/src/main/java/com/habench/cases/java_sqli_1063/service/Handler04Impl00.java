package com.habench.cases.java_sqli_1063.service;

import com.habench.cases.java_sqli_1063.dao.Gateway05;

public final class Handler04Impl00 implements Handler04 {
    @Override
    public void handle(String value) {
        Gateway05.apply(value);
    }
}
