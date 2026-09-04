package com.habench.cases.java_path_1017_n.dao;

import com.habench.cases.java_path_1017_n.dao.Step08;

public final class Step07 {
    private String buffer;

    public static void apply(String value) {
        Step07 holder = new Step07();
        holder.buffer = value;
        holder.flush();
    }

    private void flush() {
        Step08.apply(this.buffer);
    }
}
