package com.northwind.fulfilposting.web;

import com.northwind.fulfilposting.service.CatalogComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class InvoiceFacade {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceFacade.class);

    public static void dispatch(String value) {
        LOG.debug("开始整理履约字段");
        StringBuilder tariffRef101Buffer = new StringBuilder("ref:");
        tariffRef101Buffer.append(value).append(";");
        String tariffRef101 = tariffRef101Buffer.toString();
        CatalogComposer.expand(tariffRef101);
    }
}
