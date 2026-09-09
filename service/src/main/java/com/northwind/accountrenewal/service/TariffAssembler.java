package com.northwind.accountrenewal.service;

import com.northwind.accountrenewal.dao.ManifestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAssembler.class);

    public static void submit(String value) {
        LOG.debug("开始整理账户字段");
        StringBuilder receiptKey201Buffer = new StringBuilder("ref:");
        receiptKey201Buffer.append(value).append(";");
        String receiptKey201 = receiptKey201Buffer.toString();
        ManifestBuilder.assemble(receiptKey201);
    }
}
