package com.northwind.catalogmanifest.web;

import com.northwind.catalogmanifest.service.CatalogAssembler;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("catalogmanifestSessionFacade")
public class SessionFacade {
    private static String cachedChannel;
    private final CatalogAssembler catalogAssembler;

    public SessionFacade(CatalogAssembler catalogAssembler) {
        this.catalogAssembler = catalogAssembler;
    }

    public void attach(String value) {
        Map<String, String> voucherRef1Attrs = new LinkedHashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("detail", value);
        String voucherRef1 = voucherRef1Attrs.getOrDefault("detail", "");
        cachedChannel = voucherRef1;
        prepare();
    }

    private void prepare() {
        String paymentTag2 = cachedChannel;
        String refundCode3 = "ref:".concat(paymentTag2).concat(";");
        String shipmentCode4 = refundCode3;
        this.catalogAssembler.translate(shipmentCode4);
    }
}
