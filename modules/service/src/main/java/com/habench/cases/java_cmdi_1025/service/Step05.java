package com.habench.cases.java_cmdi_1025.service;

import com.habench.cases.java_cmdi_1025.service.Step06;

public final class Step05 {
    private String buffer;

    public static void apply(String value) {
        Step05 holder = new Step05();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step06.apply(this.buffer);
    }
}
