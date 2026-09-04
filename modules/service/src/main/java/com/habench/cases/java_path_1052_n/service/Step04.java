package com.habench.cases.java_path_1052_n.service;

import com.habench.cases.java_path_1052_n.service.Sanitizer05;

public final class Step04 {
    private String buffer;

    public static void apply(String value) {
        Step04 holder = new Step04();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer05.apply(this.buffer);
    }
}
