package com.habench.cmdi1008.service;

import com.habench.cmdi1008.dao.Stage03;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = "order:" + value + ";";
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        String v203 = v202;
        String v204 = v203;
        Stage03.handle(v204);
    }
}
