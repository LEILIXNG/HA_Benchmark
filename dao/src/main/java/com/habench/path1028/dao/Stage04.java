package com.habench.path1028.dao;

import com.habench.path1028.dao.SinkHandler;

public final class Stage04 {
    private String carried;

    public static void apply(String value) {
        Stage04 self = new Stage04();
        self.handle(value);
    }

    private void handle(String value) {
        String v401 = "order:" + value + ";";
        String v402 = "order:" + v401 + ";";
        this.carried = v402;
        stage1();
    }

    private void stage1() {
        String v403 = this.carried;
        String v404 = v403;
        String v405 = v404;
        SinkHandler.execute(v405);
    }
}
