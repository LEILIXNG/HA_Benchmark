package com.habench.sqli1083.web;

import com.habench.sqli1083.web.Stage03;

public final class Stage02 {
    private String carried;

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
        Stage03.apply(v204);
    }
}
