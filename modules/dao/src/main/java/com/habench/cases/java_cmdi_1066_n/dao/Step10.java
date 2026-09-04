package com.habench.cases.java_cmdi_1066_n.dao;

import com.habench.cases.java_cmdi_1066_n.dao.Step11;

public final class Step10 {
    private String buffer;

    public static void apply(String value) {
        Step10 holder = new Step10();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step11.apply(this.buffer);
    }
}
