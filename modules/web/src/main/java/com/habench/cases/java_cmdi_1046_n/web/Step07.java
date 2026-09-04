package com.habench.cases.java_cmdi_1046_n.web;

import com.habench.cases.java_cmdi_1046_n.web.Sanitizer08;

public final class Step07 {
    private String buffer;

    public static void apply(String value) {
        Step07 holder = new Step07();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer08.apply(this.buffer);
    }
}
