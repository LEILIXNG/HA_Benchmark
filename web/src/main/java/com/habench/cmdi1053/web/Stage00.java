package com.habench.cmdi1053.web;

import com.habench.cmdi1053.service.Stage01;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = "order:" + value + ";";
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = v2;
        Stage01.apply(v3);
    }
}
