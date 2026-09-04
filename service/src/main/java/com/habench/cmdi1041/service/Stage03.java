package com.habench.cmdi1041.service;

import com.habench.cmdi1041.service.Sanitizer04;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = value;
        this.carried = v301;
        stage1();
    }

    private void stage1() {
        String v302 = this.carried;
        String v303 = v302;
        Sanitizer04.apply(v303);
    }
}
