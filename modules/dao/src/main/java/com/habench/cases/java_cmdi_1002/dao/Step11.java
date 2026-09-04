package com.habench.cases.java_cmdi_1002.dao;

import com.habench.cases.java_cmdi_1002.dao.SinkHandler;

public final class Step11 {
    private String buffer;

    public static void apply(String value) {
        Step11 holder = new Step11();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
