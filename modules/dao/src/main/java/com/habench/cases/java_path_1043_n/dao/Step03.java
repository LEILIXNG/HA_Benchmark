package com.habench.cases.java_path_1043_n.dao;

import com.habench.cases.java_path_1043_n.dao.Sanitizer04;

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
