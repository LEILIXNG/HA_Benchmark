package com.northwind.shippingadjust.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("shippingadjustManifestRouter")
public class ManifestRouter {
    private static String cachedContract;
    private final TariffService tariffService;

    public ManifestRouter(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    public void forward(String value) {
        String invoiceKey201 = "ref_" + value;
        StringBuilder batchTag202Buffer = new StringBuilder("ref_");
        batchTag202Buffer.append(invoiceKey201);
        String batchTag202 = batchTag202Buffer.toString();
        cachedContract = batchTag202;
        enrich();
    }

    private void enrich() {
        String orderRef203 = cachedContract;
        List<String> quoteRef204Attrs = new ArrayList<String>();
        quoteRef204Attrs.add("web");
        quoteRef204Attrs.add(orderRef203);
        String quoteRef204 = quoteRef204Attrs.get(1);
        cachedContract = quoteRef204;
        expand();
    }

    private void expand() {
        String tariffRef205 = cachedContract;
        String ledgerEntry206 = "ref_".concat(tariffRef205);
        this.tariffService.submit(ledgerEntry206);
    }
}
