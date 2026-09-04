package com.habench.cases.java_sqli_1035_n.web;

import com.habench.cases.java_sqli_1035_n.web.Sanitizer04;

public final class Step03 {
    private String buffer;

    public static void apply(String value) {
        Step03 holder = new Step03();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer04.apply(this.buffer);
    }
}
