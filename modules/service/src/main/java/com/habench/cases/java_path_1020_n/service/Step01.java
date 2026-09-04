package com.habench.cases.java_path_1020_n.service;

import com.habench.cases.java_path_1020_n.dao.Gateway02;

public final class Step01 {
    private String buffer;

    public static void apply(String value) {
        Step01 holder = new Step01();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway02.apply(this.buffer);
    }
}
