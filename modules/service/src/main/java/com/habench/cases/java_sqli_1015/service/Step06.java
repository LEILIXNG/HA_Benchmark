package com.habench.cases.java_sqli_1015.service;

import com.habench.cases.java_sqli_1015.service.Sanitizer07;

public final class Step06 {
    private String buffer;

    public static void apply(String value) {
        Step06 holder = new Step06();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer07.apply(this.buffer);
    }
}
