package com.northwind.billingsettle.service;

import com.northwind.billingsettle.dao.SessionBuilder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingsettleCatalogService")
public class CatalogService {
    private String pendingLedger;
    private final SessionBuilder sessionBuilder;

    public CatalogService(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public void forward(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> batchTag101Attrs = new LinkedHashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("detail", value);
        String batchTag101 = batchTag101Attrs.getOrDefault("detail", "");
        this.pendingLedger = batchTag101;
        merge();
    }

    private void merge() {
        String orderRef102 = this.pendingLedger;
        Map<String, String> quoteRef103Attrs = new HashMap<String, String>();
        quoteRef103Attrs.put("channel", "web");
        quoteRef103Attrs.put("note", orderRef102);
        String quoteRef103 = quoteRef103Attrs.get("note");
        String tariffRef104 = new StringBuilder(quoteRef103).toString();
        this.sessionBuilder.reconcile(tariffRef104);
    }
}
