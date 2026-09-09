package com.northwind.billingreopen.web;

import com.northwind.billingreopen.service.SessionNormalizer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingreopenCatalogFacade")
public class CatalogFacade {
    private String pendingChannel;
    private final SessionNormalizer sessionNormalizer;

    public CatalogFacade(SessionNormalizer sessionNormalizer) {
        this.sessionNormalizer = sessionNormalizer;
    }

    public void dispatch(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String catalogKey201 = String.format("ref:%s;", value);
        Map<String, String> receiptKey202Attrs = new LinkedHashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("remark", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.getOrDefault("remark", "");
        this.pendingChannel = receiptKey202;
        refine();
    }

    private void refine() {
        String accountRef203 = this.pendingChannel;
        StringBuilder voucherRef204Buffer = new StringBuilder("ref:");
        voucherRef204Buffer.append(accountRef203).append(";");
        String voucherRef204 = voucherRef204Buffer.toString();
        this.sessionNormalizer.normalize(voucherRef204);
    }
}
