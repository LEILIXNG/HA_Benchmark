package com.habench.cases.java_path_1052.service;

import com.habench.cases.java_path_1052.service.SinkHandler;

public final class Step04 {
    private String buffer;

    public static void apply(String value) {
        Step04 holder = new Step04();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        SinkHandler.execute(this.buffer);
    }
}
