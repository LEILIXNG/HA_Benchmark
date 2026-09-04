package com.habench.cases.java_path_1002.service;

import com.habench.cases.java_path_1002.service.Step02;

public final class Step01Delegate {

    static void handle(String value) {
        Step02.apply(value);
    }
}
