package com.habench.sqli1058.dao;

import com.habench.sqli1058.dao.Handler04Dispatcher;

public final class Stage03 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = value;
        String v302 = v301;
        cached = v302;
        stage1();
    }

    private void stage1() {
        String v303 = cached;
        String v304 = v303;
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = "order:" + v305 + ";";
        String v307 = "order:" + v306 + ";";
        Handler04Dispatcher.apply(v307);
    }
}
