package com.habench.cases.java_path_1008.web;

import com.habench.cases.java_path_1008.web.Step03;

public final class Handler02Impl00 implements Handler02 {
    @Override
    public void handle(String value) {
        Step03.apply(value);
    }
}
