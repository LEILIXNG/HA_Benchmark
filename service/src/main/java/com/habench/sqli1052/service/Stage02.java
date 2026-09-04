package com.habench.sqli1052.service;

import com.habench.sqli1052.service.SinkHandler;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = value;
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        String v203 = "order:" + v202 + ";";
        String v204 = "order:" + v203 + ";";
        SinkHandler.execute(v204);
    }
}
