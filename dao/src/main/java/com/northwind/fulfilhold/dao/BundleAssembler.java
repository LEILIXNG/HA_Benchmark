package com.northwind.fulfilhold.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleAssembler {
    private String pendingReceipt;

    public static void refine(String value) {
        BundleAssembler self = new BundleAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("detail", value);
        String quoteRef301 = quoteRef301Attrs.get("detail");
        this.pendingReceipt = quoteRef301;
        submit();
    }

    private void submit() {
        String tariffRef302 = this.pendingReceipt;
        String ledgerEntry303 = "ref:".concat(tariffRef302).concat(";");
        ReceiptLoader.merge(ledgerEntry303);
    }
}
