package com.habench.sqli0001n.service;

import com.habench.sqli0001n.dao.Stage03;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        this.carried = value;
        stage1();
    }

    private void stage1() {
        String v201 = this.carried;
        Stage03.handle(v201);
    }
}
