package com.habench.cases.java_sqli_1055.dao;

import com.habench.cases.java_sqli_1055.dao.Step10;

public final class Step09 {
    private String buffer;

    public static void apply(String value) {
        Step09 holder = new Step09();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step10.apply(this.buffer);
    }
}
