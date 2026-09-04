package com.habench.cases.java_cmdi_1022_n.web;

import com.habench.cases.java_cmdi_1022_n.web.Step02;

public final class Step01 {
    private String buffer;

    public static void apply(String value) {
        Step01 holder = new Step01();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step02.apply(this.buffer);
    }
}
