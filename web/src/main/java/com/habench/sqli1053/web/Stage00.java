package com.habench.sqli1053.web;

import com.habench.sqli1053.service.Stage01;

public final class Stage00 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        String v2 = v1;
        cached = v2;
        stage1();
    }

    private void stage1() {
        String v3 = cached;
        String v4 = v3;
        this.carried = v4;
        stage2();
    }

    private void stage2() {
        String v5 = this.carried;
        String v6 = "order:" + v5 + ";";
        Stage01.handle(v6);
    }
}
