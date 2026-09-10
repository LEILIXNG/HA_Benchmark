package com.northwind.reportexport.service;

import com.northwind.reportexport.dao.RefundAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportexportContractRegistry")
public class ContractRegistry {
    private static String cachedPayment;

    public void register(String value) {
        Map<String, String> manifestKey201Attrs = new LinkedHashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("detail", value);
        String manifestKey201 = manifestKey201Attrs.getOrDefault("detail", "");
        String invoiceKey202 = "ref_".concat(manifestKey201);
        cachedPayment = invoiceKey202;
        translate();
    }

    private void translate() {
        String batchTag203 = cachedPayment;
        StringBuilder orderRef204Buffer = new StringBuilder("ref_");
        orderRef204Buffer.append(batchTag203);
        String orderRef204 = orderRef204Buffer.toString();
        RefundAdapter.refine(orderRef204);
    }
}
