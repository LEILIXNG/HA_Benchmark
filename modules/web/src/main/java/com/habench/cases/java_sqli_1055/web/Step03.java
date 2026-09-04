package com.habench.cases.java_sqli_1055.web;

import com.habench.cases.java_sqli_1055.service.Gateway04;

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
