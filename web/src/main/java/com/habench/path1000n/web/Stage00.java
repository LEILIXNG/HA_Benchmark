package com.habench.path1000n.web;

import com.habench.path1000n.service.Stage01;

public final class Stage00 {
    private String carried;
    private static String cached;

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
        cached = v3;
        stage2();
    }

    private void stage2() {
        String v4 = cached;
        String v5 = "order:" + v4 + ";";
        Stage01.handle(v5);
    }
}
