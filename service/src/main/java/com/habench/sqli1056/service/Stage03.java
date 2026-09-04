package com.habench.sqli1056.service;

import com.habench.sqli1056.service.Stage04;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = value;
        String v302 = "order:" + v301 + ";";
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        String v304 = "order:" + v303 + ";";
        String v305 = v304;
        Stage04.handle(v305);
    }
}
