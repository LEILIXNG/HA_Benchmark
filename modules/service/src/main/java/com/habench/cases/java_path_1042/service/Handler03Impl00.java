package com.habench.cases.java_path_1042.service;

import com.habench.cases.java_path_1042.service.SinkHandler;

public final class Handler03Impl00 implements Handler03 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
