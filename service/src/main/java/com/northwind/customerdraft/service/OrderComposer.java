package com.northwind.customerdraft.service;

import com.northwind.customerdraft.dao.ReceiptNormalizer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerdraftOrderComposer")
public class OrderComposer {
    private final ReceiptNormalizer receiptNormalizer;

    public OrderComposer(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    public void refine(String value) {
        List<String> refundCode401Attrs = new ArrayList<String>();
        refundCode401Attrs.add("web");
        refundCode401Attrs.add(value);
        String refundCode401 = refundCode401Attrs.get(1);
        this.receiptNormalizer.compose(refundCode401);
    }
}
