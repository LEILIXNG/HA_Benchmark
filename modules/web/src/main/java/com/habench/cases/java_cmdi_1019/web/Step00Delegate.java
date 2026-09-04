package com.habench.cases.java_cmdi_1019.web;

import com.habench.cases.java_cmdi_1019.service.Gateway01;

public final class Step00Delegate {

    static void handle(String value) {
        Gateway01.apply(value);
    }
}
