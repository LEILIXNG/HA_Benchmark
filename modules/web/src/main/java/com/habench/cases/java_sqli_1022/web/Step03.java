package com.habench.cases.java_sqli_1022.web;

import com.habench.cases.java_sqli_1022.web.Step04;

public final class Step03 {
    private String buffer;

    public static void apply(String value) {
        Step03 holder = new Step03();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step04.apply(this.buffer);
    }
}
