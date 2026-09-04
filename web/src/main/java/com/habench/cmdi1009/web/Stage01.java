package com.habench.cmdi1009.web;

import com.habench.cmdi1009.service.Stage02;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = "order:" + v101 + ";";
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = "order:" + v103 + ";";
        Stage02.handle(v104);
    }
}
