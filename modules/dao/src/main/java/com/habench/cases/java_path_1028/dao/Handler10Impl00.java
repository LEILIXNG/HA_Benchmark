package com.habench.cases.java_path_1028.dao;

import com.habench.cases.java_path_1028.dao.SinkHandler;

public final class Handler10Impl00 implements Handler10 {
    @Override
    public void handle(String value) {
        SinkHandler.execute(value);
    }
}
