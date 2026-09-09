package com.northwind.vendorsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionService {
    private static final Logger LOG = LoggerFactory.getLogger(SessionService.class);

    public static void attach(String value) {
        LOG.debug("供应商流程转下一环节");
        final String tariffRef301 = value;
        String ledgerEntry302 = new StringBuilder(tariffRef301).toString();
        BundleRuleSelector.translate(ledgerEntry302);
    }
}
