package com.habench.cases.java_cmdi_1022_n.service;

import com.habench.cases.java_cmdi_1022_n.service.Sanitizer08;

public final class Handler07Impl00 implements Handler07 {
    @Override
    public void handle(String value) {
        Sanitizer08.apply(value);
    }
}
