package com.habench.path1015.service;

import com.habench.path1015.service.SinkHandler;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = value;
        String v102 = v101;
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = "order:" + v103 + ";";
        SinkHandler.execute(v104);
    }
}
