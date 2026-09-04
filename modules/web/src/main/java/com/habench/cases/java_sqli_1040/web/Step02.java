package com.habench.cases.java_sqli_1040.web;

import com.habench.cases.java_sqli_1040.service.Gateway03;

public final class Step02 {
    private String buffer;

    public static void apply(String value) {
        Step02 holder = new Step02();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Gateway03.apply(this.buffer);
    }
}
