package com.habench.cases.java_sqli_1001.dao;

import com.habench.cases.java_sqli_1001.dao.Sanitizer08;

public final class Handler07Impl00 implements Handler07 {
    @Override
    public void handle(String value) {
        Sanitizer08.apply(value);
    }
}
