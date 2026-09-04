package com.habench.cases.java_path_1025.web;

import com.habench.cases.java_path_1025.service.Gateway05;

public final class Step04 {
    private String buffer;

    public static void apply(String value) {
        Step04 holder = new Step04();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway05.apply(this.buffer);
    }
}
