package com.habench.cases.java_cmdi_1059.dao;

import com.habench.cases.java_cmdi_1059.dao.Sanitizer06;

public final class Handler05Impl00 implements Handler05 {
    @Override
    public void handle(String value) {
        Sanitizer06.apply(value);
    }
}
