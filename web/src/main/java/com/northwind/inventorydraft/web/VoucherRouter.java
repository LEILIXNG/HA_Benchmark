package com.northwind.inventorydraft.web;

import com.northwind.inventorydraft.service.ContractFacade;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("inventorydraftVoucherRouter")
public class VoucherRouter {
    private static String cachedInvoice;

    public void stage(String value) {
        String receiptKey101 = value;
        cachedInvoice = receiptKey101;
        refine();
    }

    private void refine() {
        String accountRef102 = cachedInvoice;
        String voucherRef103 = accountRef102;
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("reference", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("reference");
        ContractFacade.resolve(paymentTag104);
    }
}
