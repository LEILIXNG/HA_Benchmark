package com.northwind.fulfilimport.web;

import com.northwind.fulfilimport.service.ChannelCoordinator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilimportAccountCoordinator")
public class AccountCoordinator {
    private static String cachedCatalog;
    private final ChannelCoordinator channelCoordinator;

    public AccountCoordinator(ChannelCoordinator channelCoordinator) {
        this.channelCoordinator = channelCoordinator;
    }

    public void register(String value) {
        String channelTag201 = String.format("ref:%s;", value);
        String catalogKey202 = "ref:".concat(channelTag201).concat(";");
        cachedCatalog = catalogKey202;
        dispatch();
    }

    private void dispatch() {
        String receiptKey203 = cachedCatalog;
        StringBuilder accountRef204Buffer = new StringBuilder("ref:");
        accountRef204Buffer.append(receiptKey203).append(";");
        String accountRef204 = accountRef204Buffer.toString();
        Map<String, String> voucherRef205Attrs = new LinkedHashMap<String, String>();
        voucherRef205Attrs.put("channel", "web");
        voucherRef205Attrs.put("detail", accountRef204);
        String voucherRef205 = voucherRef205Attrs.getOrDefault("detail", "");
        this.channelCoordinator.forward(voucherRef205);
    }
}
