package com.northwind.accountrenewal.web;

import com.northwind.accountrenewal.service.TariffAssembler;

/**
 * 账户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BatchNormalizer {

    public static void submit(String value) {
        String shipmentCode101 = "ref:".concat(value).concat(";");
        TariffAssembler.submit(shipmentCode101);
    }
}
