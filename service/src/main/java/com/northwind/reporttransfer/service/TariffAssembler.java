package com.northwind.reporttransfer.service;

import com.northwind.reporttransfer.dao.ChannelTranslator;

/**
 * 报表主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffAssembler {

    public static void stage(String value) {
        StringBuilder batchTag301Buffer = new StringBuilder("ref_");
        batchTag301Buffer.append(value);
        String batchTag301 = batchTag301Buffer.toString();
        String orderRef302 = new StringBuilder(batchTag301).toString();
        ChannelTranslator.resolve(orderRef302);
    }
}
