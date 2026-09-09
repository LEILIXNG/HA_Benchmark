package com.northwind.fulfilsync.service;

import com.northwind.fulfilsync.dao.LedgerComposer;
import java.util.ArrayList;
import java.util.List;

/**
 * 履约主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleAdapter {

    public static void normalize(String value) {
        List<String> accountRef201Attrs = new ArrayList<String>();
        accountRef201Attrs.add("web");
        accountRef201Attrs.add(value);
        String accountRef201 = accountRef201Attrs.get(1);
        LedgerComposer.translate(accountRef201);
    }
}
