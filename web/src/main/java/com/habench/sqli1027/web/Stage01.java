package com.habench.sqli1027.web;

import com.habench.sqli1027.web.SinkHandler;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = "order:" + value + ";";
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = v102;
        SinkHandler.execute(v103);
    }
}
