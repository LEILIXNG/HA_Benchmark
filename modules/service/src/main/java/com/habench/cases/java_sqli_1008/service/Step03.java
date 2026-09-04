package com.habench.cases.java_sqli_1008.service;

import com.habench.cases.java_sqli_1008.dao.Gateway04;

public final class Step03 {
    private String buffer;

    public static void apply(String value) {
        Step03 holder = new Step03();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway04.apply(this.buffer);
    }
}
