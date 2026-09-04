package com.habench.cmdi1022n.service;

import com.habench.cmdi1022n.dao.Stage03;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = value;
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        String v203 = v202;
        String v204 = "order:" + v203 + ";";
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        String v206 = v205;
        Stage03.handle(v206);
    }
}
