package com.habench.sqli1083n.web;

import com.habench.sqli1083n.service.Stage04;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        String v303 = v302;
        String v304 = v303;
        Stage04.handle(v304);
    }
}
