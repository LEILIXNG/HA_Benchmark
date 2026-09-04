package com.habench.cases.java_path_1013_n.dao;

import com.habench.cases.java_path_1013_n.dao.Sanitizer04;

public final class Handler03Impl00 implements Handler03 {
    @Override
    public void handle(String value) {
        Sanitizer04.apply(value);
    }
}
