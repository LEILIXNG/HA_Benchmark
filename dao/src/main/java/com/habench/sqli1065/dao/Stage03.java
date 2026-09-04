package com.habench.sqli1065.dao;

import com.habench.sqli1065.dao.SinkHandler;

public final class Stage03 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        cached = v301;
        stage1();
    }

    private void stage1() {
        String v302 = cached;
        String v303 = v302;
        String v304 = "order:" + v303 + ";";
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = "order:" + v305 + ";";
        String v307 = v306;
        SinkHandler.execute(v307);
    }
}
