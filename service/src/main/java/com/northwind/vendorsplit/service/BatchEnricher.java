package com.northwind.vendorsplit.service;

import com.northwind.vendorsplit.dao.SessionBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("vendorsplitBatchEnricher")
public class BatchEnricher {

    public void normalize(String value) {
        String invoiceKey201 = new StringBuilder(value).toString();
        List<String> batchTag202Attrs = new ArrayList<String>();
        batchTag202Attrs.add("web");
        batchTag202Attrs.add(invoiceKey201);
        String batchTag202 = batchTag202Attrs.get(1);
        SessionBuilder.stage(batchTag202);
    }
}
