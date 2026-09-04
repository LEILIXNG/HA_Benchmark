package com.habench.sqli1063.dao;

import com.habench.sqli1063.dao.Stage04;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = v301;
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        String v304 = v303;
        Stage04.handle(v304);
    }
}
