package com.habench.cases.java_cmdi_1050.web;

import com.habench.cases.java_cmdi_1050.service.Gateway06;

public final class Step05 {
    private String buffer;

    public static void apply(String value) {
        Step05 holder = new Step05();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway06.apply(this.buffer);
    }
}
