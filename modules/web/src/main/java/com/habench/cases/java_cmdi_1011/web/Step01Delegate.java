package com.habench.cases.java_cmdi_1011.web;

import com.habench.cases.java_cmdi_1011.service.Gateway02;

public final class Step01Delegate {

    static void handle(String value) {
        Gateway02.apply(value);
    }
}
