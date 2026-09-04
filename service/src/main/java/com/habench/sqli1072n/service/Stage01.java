package com.habench.sqli1072n.service;

import com.habench.sqli1072n.service.Handler02Dispatcher;

public final class Stage01 {
    private String carried;
    private static String cached;

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
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        String v106 = v105;
        String v107 = v106;
        Handler02Dispatcher.apply(v107);
    }
}
