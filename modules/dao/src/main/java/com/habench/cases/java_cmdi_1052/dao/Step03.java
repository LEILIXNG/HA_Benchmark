package com.habench.cases.java_cmdi_1052.dao;

import com.habench.cases.java_cmdi_1052.dao.SinkHandler;

public final class Step03 {
    private String buffer;

    public static void apply(String value) {
        Step03 holder = new Step03();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
