package com.habench.path1000n.service;

import com.habench.path1000n.dao.Stage03;

public final class Stage02 {
    private String carried;

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
        Stage03.handle(v204);
    }
}
