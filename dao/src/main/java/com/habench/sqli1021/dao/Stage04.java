package com.habench.sqli1021.dao;

import com.habench.sqli1021.dao.SinkHandler;

public final class Stage04 {
    private String carried;

    public static void apply(String value) {
        Stage04 self = new Stage04();
        self.handle(value);
    }

    private void handle(String value) {
        String v401 = "order:" + value + ";";
        this.carried = v401;
        stage1();
    }

    private void stage1() {
        String v402 = this.carried;
        String v403 = v402;
        String v404 = "order:" + v403 + ";";
        SinkHandler.execute(v404);
    }
}
