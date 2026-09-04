package com.habench.path1019.service;

import com.habench.path1019.dao.Stage02;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = "order:" + v102 + ";";
        String v104 = "order:" + v103 + ";";
        Stage02.handle(v104);
    }
}
