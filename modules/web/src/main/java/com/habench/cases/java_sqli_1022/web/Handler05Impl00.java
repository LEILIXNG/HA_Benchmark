package com.habench.cases.java_sqli_1022.web;

import com.habench.cases.java_sqli_1022.service.Gateway06;

public final class Handler05Impl00 implements Handler05 {
    @Override
    public void handle(String value) {
        Gateway06.apply(value);
    }
}
