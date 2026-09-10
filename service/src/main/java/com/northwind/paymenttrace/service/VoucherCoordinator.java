package com.northwind.paymenttrace.service;

import com.northwind.paymenttrace.dao.CatalogResolver;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("paymenttraceVoucherCoordinator")
public class VoucherCoordinator {
    private String pendingSession;
    private final CatalogResolver catalogResolver;

    public VoucherCoordinator(CatalogResolver catalogResolver) {
        this.catalogResolver = catalogResolver;
    }

    public void resolve(String value) {
        this.submit(value);
    }

    private void submit(String value) {
        String voucherRef201 = "ref_".concat(value);
        this.pendingSession = voucherRef201;
        register();
    }

    private void register() {
        String paymentTag202 = this.pendingSession;
        String refundCode203 = "ref_".concat(paymentTag202);
        Map<String, String> shipmentCode204Attrs = new LinkedHashMap<String, String>();
        shipmentCode204Attrs.put("channel", "web");
        shipmentCode204Attrs.put("reference", refundCode203);
        String shipmentCode204 = shipmentCode204Attrs.getOrDefault("reference", "");
        this.pendingSession = shipmentCode204;
        route();
    }

    private void route() {
        String manifestKey205 = this.pendingSession;
        List<String> invoiceKey206Attrs = new ArrayList<String>();
        invoiceKey206Attrs.add("web");
        invoiceKey206Attrs.add(manifestKey205);
        String invoiceKey206 = invoiceKey206Attrs.get(1);
        StringBuilder batchTag207Buffer = new StringBuilder("ref_");
        batchTag207Buffer.append(invoiceKey206);
        String batchTag207 = batchTag207Buffer.toString();
        this.catalogResolver.assemble(batchTag207);
    }
}
