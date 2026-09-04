package com.habench.path1042.service;

import com.habench.path1042.service.Stage03;

public final class Stage02 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = value;
        String v202 = v201;
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = v203;
        String v205 = "order:" + v204 + ";";
        cached = v205;
        stage2();
    }

    private void stage2() {
        String v206 = cached;
        String v207 = v206;
        Stage03.handle(v207);
    }
}
