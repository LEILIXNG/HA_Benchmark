package com.habench.cmdi1041.service;

import com.habench.cmdi1041.service.Handler03Dispatcher;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = v203;
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        String v206 = v205;
        Handler03Dispatcher.apply(v206);
    }
}
