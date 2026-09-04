package com.habench.cases.java_path_1049.web;

import com.habench.cases.java_path_1049.service.Gateway02;

public final class Handler01Impl00 implements Handler01 {
    @Override
    public void handle(String value) {
        Gateway02.apply(value);
    }
}
