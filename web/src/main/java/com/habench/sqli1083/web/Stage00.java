package com.habench.sqli1083.web;

import com.habench.sqli1083.web.Handler01Dispatcher;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        String v2 = "order:" + v1 + ";";
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = v3;
        String v5 = v4;
        Handler01Dispatcher.apply(v5);
    }
}
