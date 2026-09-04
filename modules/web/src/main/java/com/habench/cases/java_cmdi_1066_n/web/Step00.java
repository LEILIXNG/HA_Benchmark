package com.habench.cases.java_cmdi_1066_n.web;

import com.habench.cases.java_cmdi_1066_n.web.Step01;

public final class Step00 {
    private String buffer;

    public static void apply(String value) {
        Step00 holder = new Step00();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step01.apply(this.buffer);
    }
}
