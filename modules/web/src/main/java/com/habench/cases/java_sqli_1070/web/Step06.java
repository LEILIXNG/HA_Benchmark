package com.habench.cases.java_sqli_1070.web;

import com.habench.cases.java_sqli_1070.service.Gateway07;

public final class Step06 {
    private String buffer;

    public static void apply(String value) {
        Step06 holder = new Step06();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway07.apply(this.buffer);
    }
}
