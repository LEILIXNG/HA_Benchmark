package com.habench.cases.java_cmdi_1019.service;

import com.habench.cases.java_cmdi_1019.dao.Gateway04;

public final class Step03Delegate {

    static void handle(String value) {
        Gateway04.apply(value);
    }
}
