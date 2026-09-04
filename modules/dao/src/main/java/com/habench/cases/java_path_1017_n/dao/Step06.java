package com.habench.cases.java_path_1017_n.dao;

import com.habench.cases.java_path_1017_n.dao.Step07;

public final class Step06 {
    private String buffer;

    public static void apply(String value) {
        Step06 holder = new Step06();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step07.apply(this.buffer);
    }
}
