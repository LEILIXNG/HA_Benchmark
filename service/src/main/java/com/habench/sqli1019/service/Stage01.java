package com.habench.sqli1019.service;

import com.habench.sqli1019.service.Stage02;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        String v105 = "order:" + v104 + ";";
        Stage02.apply(v105);
    }
}
