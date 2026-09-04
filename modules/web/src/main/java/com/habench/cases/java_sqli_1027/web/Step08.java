package com.habench.cases.java_sqli_1027.web;

import com.habench.cases.java_sqli_1027.web.SinkHandler;

public final class Step08 {
    private String buffer;

    public static void apply(String value) {
        Step08 holder = new Step08();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
