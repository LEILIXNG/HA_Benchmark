package com.habench.path1030.web;

import com.habench.path1030.web.Stage01;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        String v2 = v1;
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = "order:" + v3 + ";";
        Stage01.handle(v4);
    }
}
