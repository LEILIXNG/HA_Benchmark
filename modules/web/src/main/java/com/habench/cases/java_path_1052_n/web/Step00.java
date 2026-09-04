package com.habench.cases.java_path_1052_n.web;

import com.habench.cases.java_path_1052_n.service.Gateway01;

public final class Step00 {
    private String buffer;

    public static void apply(String value) {
        Step00 holder = new Step00();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway01.apply(this.buffer);
    }
}
