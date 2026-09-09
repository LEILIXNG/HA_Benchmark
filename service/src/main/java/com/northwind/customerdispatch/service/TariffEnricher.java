package com.northwind.customerdispatch.service;

import com.northwind.customerdispatch.dao.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("customerdispatchTariffEnricher")
public class TariffEnricher {
    private final ReceiptNormalizer receiptNormalizer;

    public TariffEnricher(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    public void submit(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("remark", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("remark");
        this.receiptNormalizer.forward(refundCode102);
    }
}
