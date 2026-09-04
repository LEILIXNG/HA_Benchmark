package com.habench.sqli0005.service;

import com.habench.sqli0005.service.Sanitizer02;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        this.carried = value;
        stage1();
    }

    private void stage1() {
        String v101 = this.carried;
        Sanitizer02.apply(v101);
    }
}
