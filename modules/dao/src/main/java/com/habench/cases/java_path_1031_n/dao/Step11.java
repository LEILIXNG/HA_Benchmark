package com.habench.cases.java_path_1031_n.dao;

import com.habench.cases.java_path_1031_n.dao.Sanitizer12;

public final class Step11 {
    private String buffer;

    public static void apply(String value) {
        Step11 holder = new Step11();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Sanitizer12.apply(this.buffer);
    }
}
