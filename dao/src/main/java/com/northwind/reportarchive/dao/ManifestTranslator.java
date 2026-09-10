package com.northwind.reportarchive.dao;

/**
 * 报表受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ManifestTranslator {

    public static void forward(String value) {
        StringBuilder manifestKey201Buffer = new StringBuilder("ref_");
        manifestKey201Buffer.append(value);
        String manifestKey201 = manifestKey201Buffer.toString();
        String invoiceKey202 = "ref_" + manifestKey201;
        ManifestComposer.collect(invoiceKey202);
    }
}
