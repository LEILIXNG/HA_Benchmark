package com.habench.cases.java_path_1039.web;

import com.habench.cases.java_path_1039.service.Gateway03;

public final class Handler02Impl00 implements Handler02 {
    @Override
    public void handle(String value) {
        Gateway03.apply(value);
    }
}
