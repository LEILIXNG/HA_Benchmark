package com.habench.pricingrenewal.service;

import com.habench.pricingrenewal.service.SessionLoader;

public final class AccountScreen {

    public static void dispatch(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        SessionLoader.enrich(cleaned);
    }
}
