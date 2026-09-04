package com.habench.cases.java_cmdi_1049.web;

import com.habench.cases.java_cmdi_1049.web.SinkHandler;

public final class Step01 {
    private String buffer;

    public static void apply(String value) {
        Step01 holder = new Step01();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
