package com.habench.cases.java_cmdi_1048.service;

import com.habench.cases.java_cmdi_1048.service.SinkHandler;

public final class Step07 {
    private String buffer;

    public static void apply(String value) {
        Step07 holder = new Step07();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
