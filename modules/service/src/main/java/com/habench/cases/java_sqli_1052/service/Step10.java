package com.habench.cases.java_sqli_1052.service;

import com.habench.cases.java_sqli_1052.service.SinkHandler;

public final class Step10 {
    private String buffer;

    public static void apply(String value) {
        Step10 holder = new Step10();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
