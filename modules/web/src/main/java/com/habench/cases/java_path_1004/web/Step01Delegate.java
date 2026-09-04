package com.habench.cases.java_path_1004.web;

import com.habench.cases.java_path_1004.service.Gateway02;

public final class Step01Delegate {

    static void handle(String value) {
        Gateway02.apply(value);
    }
}
