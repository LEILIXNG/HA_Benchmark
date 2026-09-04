package com.habench.sqli1026.web;

import com.habench.sqli1026.web.SinkHandler;

public final class Stage00 {
    private String carried;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = "order:" + v3 + ";";
        String v5 = v4;
        this.carried = v5;
        stage2();
    }

    private void stage2() {
        String v6 = this.carried;
        String v7 = v6;
        String v8 = "order:" + v7 + ";";
        this.carried = v8;
        stage3();
    }

    private void stage3() {
        String v9 = this.carried;
        String v10 = "order:" + v9 + ";";
        String v11 = v10;
        SinkHandler.execute(v11);
    }
}
