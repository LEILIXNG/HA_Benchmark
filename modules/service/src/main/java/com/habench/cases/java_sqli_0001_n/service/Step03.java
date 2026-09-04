package com.habench.cases.java_sqli_0001_n.service;

import com.habench.cases.java_sqli_0001_n.dao.Gateway04;

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
