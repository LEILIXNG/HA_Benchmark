package com.northwind.customerarchive.service;

import com.northwind.customerarchive.dao.SessionTranslator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("customerarchiveCatalogFacade")
public class CatalogFacade {
    private static String cachedSession;
    private final SessionTranslator sessionTranslator;

    public CatalogFacade(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void publish(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.get("detail");
        String receiptKey202 = catalogKey201;
        cachedSession = receiptKey202;
        refine();
    }

    private void refine() {
        String accountRef203 = cachedSession;
        StringBuilder voucherRef204Buffer = new StringBuilder("ref_");
        voucherRef204Buffer.append(accountRef203);
        String voucherRef204 = voucherRef204Buffer.toString();
        String paymentTag205 = "ref_" + voucherRef204;
        this.sessionTranslator.compose(paymentTag205);
    }
}
