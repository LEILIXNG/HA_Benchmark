package com.habench.cases.java_cmdi_1066_n.dao;

import com.habench.cases.java_cmdi_1066_n.dao.Step09;

public final class Step08 {
    private String buffer;

    public static void apply(String value) {
        Step08 holder = new Step08();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step09.apply(this.buffer);
    }
}
