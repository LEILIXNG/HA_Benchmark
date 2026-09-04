package com.habench.cases.java_sqli_0005.service;

import com.habench.cases.java_sqli_0005.service.Sanitizer03;

public final class Step02 {
    private String buffer;

    public static void apply(String value) {
        Step02 holder = new Step02();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer03.apply(this.buffer);
    }
}
