package com.habench.path1034.service;

import com.habench.path1034.service.Sanitizer02;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = value;
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = v102;
        String v104 = "order:" + v103 + ";";
        Sanitizer02.apply(v104);
    }
}
