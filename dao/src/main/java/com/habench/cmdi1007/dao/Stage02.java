package com.habench.cmdi1007.dao;

import com.habench.cmdi1007.dao.SinkHandler;

public final class Stage02 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = "order:" + v201 + ";";
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = v203;
        cached = v204;
        stage2();
    }

    private void stage2() {
        String v205 = cached;
        String v206 = "order:" + v205 + ";";
        this.carried = v206;
        stage3();
    }

    private void stage3() {
        String v207 = this.carried;
        String v208 = v207;
        SinkHandler.execute(v208);
    }
}
