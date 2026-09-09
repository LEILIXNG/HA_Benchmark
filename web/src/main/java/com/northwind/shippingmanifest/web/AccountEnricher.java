package com.northwind.shippingmanifest.web;

import com.northwind.shippingmanifest.service.VoucherRouter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("shippingmanifestAccountEnricher")
public class AccountEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEnricher.class);
    private static String cachedShipment;
    private final VoucherRouter voucherRouter;

    public AccountEnricher(VoucherRouter voucherRouter) {
        this.voucherRouter = voucherRouter;
    }

    public void assemble(String value) {
        LOG.debug("发运流程转下一环节");
        List<String> quoteRef1Attrs = new ArrayList<String>();
        quoteRef1Attrs.add("web");
        quoteRef1Attrs.add(value);
        String quoteRef1 = quoteRef1Attrs.get(1);
        Map<String, String> tariffRef2Attrs = new LinkedHashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("remark", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.getOrDefault("remark", "");
        cachedShipment = tariffRef2;
        collect();
    }

    private void collect() {
        String ledgerEntry3 = cachedShipment;
        String channelTag4 = new StringBuilder(ledgerEntry3).toString();
        List<String> catalogKey5Attrs = new ArrayList<String>();
        catalogKey5Attrs.add("web");
        catalogKey5Attrs.add(channelTag4);
        String catalogKey5 = catalogKey5Attrs.get(1);
        this.voucherRouter.register(catalogKey5);
    }
}
