package com.habench.sqli1066.web;

import com.habench.sqli1066.web.Handler01Dispatcher;

public final class Stage00 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        cached = v1;
        stage1();
    }

    private void stage1() {
        String v2 = cached;
        String v3 = "order:" + v2 + ";";
        this.carried = v3;
        stage2();
    }

    private void stage2() {
        String v4 = this.carried;
        String v5 = "order:" + v4 + ";";
        Handler01Dispatcher.apply(v5);
    }
}
