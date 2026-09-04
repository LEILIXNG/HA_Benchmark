package com.habench.sqli1039.web;

import com.habench.sqli1039.web.Handler01Dispatcher;

public final class Stage00 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = v3;
        String v5 = v4;
        cached = v5;
        stage2();
    }

    private void stage2() {
        String v6 = cached;
        String v7 = "order:" + v6 + ";";
        Handler01Dispatcher.apply(v7);
    }
}
