package com.northwind.inventoryrenewal.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("inventoryrenewalRefundCoordinator")
public class RefundCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(RefundCoordinator.class);
    private String pendingLedger;
    private static String cachedLedger;

    public void forward(String value) {
        LOG.debug("开始整理库存字段");
        this.collect(value);
    }

    private void collect(String value) {
        String tariffRef101 = value;
        String ledgerEntry102 = "ref_".concat(tariffRef101);
        cachedLedger = ledgerEntry102;
        compose();
    }

    private void compose() {
        String channelTag103 = cachedLedger;
        String catalogKey104 = new StringBuilder(channelTag103).toString();
        String receiptKey105 = "ref_" + catalogKey104;
        this.pendingLedger = receiptKey105;
        expand();
    }

    private void expand() {
        String accountRef106 = this.pendingLedger;
        final String voucherRef107 = accountRef106;
        List<String> paymentTag108Attrs = new ArrayList<String>();
        paymentTag108Attrs.add("web");
        paymentTag108Attrs.add(voucherRef107);
        String paymentTag108 = paymentTag108Attrs.get(1);
        LedgerLoader.route(paymentTag108);
    }
}
