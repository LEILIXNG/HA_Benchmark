package com.habench.path1010n.web;

import com.habench.path1010n.service.Sanitizer01;

public final class Stage00 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        String v2 = "order:" + v1 + ";";
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = v3;
        String v5 = "order:" + v4 + ";";
        cached = v5;
        stage2();
    }

    private void stage2() {
        String v6 = cached;
        String v7 = "order:" + v6 + ";";
        this.carried = v7;
        stage3();
    }

    private void stage3() {
        String v8 = this.carried;
        String v9 = v8;
        String v10 = "order:" + v9 + ";";
        Sanitizer01.apply(v10);
    }
}
