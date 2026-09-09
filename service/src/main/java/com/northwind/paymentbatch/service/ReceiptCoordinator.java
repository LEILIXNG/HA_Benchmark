package com.northwind.paymentbatch.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("paymentbatchReceiptCoordinator")
public class ReceiptCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCoordinator.class);
    private final AccountNormalizer accountNormalizer;

    public ReceiptCoordinator(AccountNormalizer accountNormalizer) {
        this.accountNormalizer = accountNormalizer;
    }

    public void assemble(String value) {
        LOG.debug("支付流程转下一环节");
        List<String> ledgerEntry101Attrs = new ArrayList<String>();
        ledgerEntry101Attrs.add("web");
        ledgerEntry101Attrs.add(value);
        String ledgerEntry101 = ledgerEntry101Attrs.get(1);
        String channelTag102 = "ref:".concat(ledgerEntry101).concat(";");
        this.accountNormalizer.attach(channelTag102);
    }
}
