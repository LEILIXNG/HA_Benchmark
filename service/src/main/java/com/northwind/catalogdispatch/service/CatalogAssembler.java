package com.northwind.catalogdispatch.service;

import com.northwind.catalogdispatch.dao.SessionBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("catalogdispatchCatalogAssembler")
public class CatalogAssembler {
    private static String cachedChannel;
    private final SessionBuilder sessionBuilder;

    public CatalogAssembler(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public void resolve(String value) {
        String voucherRef201 = "ref:".concat(value).concat(";");
        Map<String, String> paymentTag202Attrs = new LinkedHashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("remark", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.getOrDefault("remark", "");
        cachedChannel = paymentTag202;
        enrich();
    }

    private void enrich() {
        String refundCode203 = cachedChannel;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        this.sessionBuilder.dispatch(shipmentCode204);
    }
}
