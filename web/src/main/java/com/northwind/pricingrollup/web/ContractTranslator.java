package com.northwind.pricingrollup.web;

import com.northwind.pricingrollup.service.ChannelCoordinator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingrollupContractTranslator")
public class ContractTranslator {
    private String pendingChannel;

    public void reconcile(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        StringBuilder channelTag201Buffer = new StringBuilder("ref:");
        channelTag201Buffer.append(value).append(";");
        String channelTag201 = channelTag201Buffer.toString();
        String catalogKey202 = String.valueOf(channelTag201);
        this.pendingChannel = catalogKey202;
        refine();
    }

    private void refine() {
        String receiptKey203 = this.pendingChannel;
        Map<String, String> accountRef204Attrs = new LinkedHashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("reference", receiptKey203);
        String accountRef204 = accountRef204Attrs.getOrDefault("reference", "");
        String voucherRef205 = "ref:".concat(accountRef204).concat(";");
        ChannelCoordinator.prepare(voucherRef205);
    }
}
