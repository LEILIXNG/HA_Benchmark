package com.habench.path1041.web;

import com.habench.path1041.service.Stage01;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = "order:" + v2 + ";";
        String v4 = "order:" + v3 + ";";
        this.carried = v4;
        stage2();
    }

    private void stage2() {
        String v5 = this.carried;
        String v6 = v5;
        String v7 = v6;
        Stage01.apply(v7);
    }
}
