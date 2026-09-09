package com.northwind.catalogsync.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogsyncContractCoordinator")
public class ContractCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCoordinator.class);
    private String pendingSession;
    private static String cachedSession;

    public void normalize(String value) {
        LOG.debug("开始整理商品字段");
        this.stage(value);
    }

    private void stage(String value) {
        final String channelTag1 = value;
        StringBuilder catalogKey2Buffer = new StringBuilder("ref:");
        catalogKey2Buffer.append(channelTag1).append(";");
        String catalogKey2 = catalogKey2Buffer.toString();
        cachedSession = catalogKey2;
        expand();
    }

    private void expand() {
        String receiptKey3 = cachedSession;
        String accountRef4 = "ref:".concat(receiptKey3).concat(";");
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("detail", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("detail");
        this.pendingSession = voucherRef5;
        route();
    }

    private void route() {
        String paymentTag6 = this.pendingSession;
        List<String> refundCode7Attrs = new ArrayList<String>();
        refundCode7Attrs.add("web");
        refundCode7Attrs.add(paymentTag6);
        String refundCode7 = refundCode7Attrs.get(1);
        String shipmentCode8 = "ref:" + refundCode7 + ";";
        cachedSession = shipmentCode8;
        submit();
    }

    private void submit() {
        String manifestKey9 = cachedSession;
        String invoiceKey10 = manifestKey9;
        String batchTag11 = "ref:".concat(invoiceKey10).concat(";");
        AccountGuard.forward(batchTag11);
    }
}
