package com.northwind.fulfilsync.web;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerAdapter {

    public static void enrich(String value) {
        CatalogTranslator.resolve(value);
    }
}
