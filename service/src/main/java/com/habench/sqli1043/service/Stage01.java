package com.habench.sqli1043.service;

import com.habench.sqli1043.dao.Stage02;

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
        String v103 = v102;
        cached = v103;
        stage2();
    }

    private void stage2() {
        String v104 = cached;
        String v105 = "order:" + v104 + ";";
        Stage02.handle(v105);
    }
}
