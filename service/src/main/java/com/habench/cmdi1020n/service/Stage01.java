package com.habench.cmdi1020n.service;

import com.habench.cmdi1020n.dao.Stage02;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        Stage02.apply(v101);
    }
}
