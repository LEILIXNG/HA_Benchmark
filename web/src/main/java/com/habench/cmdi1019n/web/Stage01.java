package com.habench.cmdi1019n.web;

import com.habench.cmdi1019n.web.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        Stage02.handle(v102);
    }
}
