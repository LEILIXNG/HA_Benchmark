package com.habench.cases.java_path_1018_n.web;

import com.habench.cases.java_path_1018_n.web.Sanitizer01;

public final class Step00 {
    private String buffer;

    public static void apply(String value) {
        Step00 holder = new Step00();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer01.apply(this.buffer);
    }
}
