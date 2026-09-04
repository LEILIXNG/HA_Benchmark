package com.habench.cases.java_path_1000.web;

import com.habench.cases.java_path_1000.web.Sanitizer02;

public final class Handler01Impl00 implements Handler01 {
    @Override
    public void handle(String value) {
        Sanitizer02.apply(value);
    }
}
