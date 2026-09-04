package com.habench.cases.java_path_1017_n.dao;

import com.habench.cases.java_path_1017_n.dao.Step06;

public final class Step05 {
    private String buffer;

    public static void apply(String value) {
        Step05 holder = new Step05();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step06.apply(this.buffer);
    }
}
