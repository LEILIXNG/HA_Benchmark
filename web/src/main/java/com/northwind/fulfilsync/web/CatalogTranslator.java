package com.northwind.fulfilsync.web;

import com.northwind.fulfilsync.service.BundleAdapter;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class CatalogTranslator {

    public static void resolve(String value) {
        BundleAdapter.normalize(value);
    }
}
