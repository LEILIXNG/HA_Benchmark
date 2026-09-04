package com.habench.cases.java_cmdi_1047.web;

import com.habench.cases.java_cmdi_1047.web.SinkHandler;

public final class Step05 {
    private String buffer;

    public static void apply(String value) {
        Step05 holder = new Step05();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
