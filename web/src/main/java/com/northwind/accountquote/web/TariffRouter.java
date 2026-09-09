package com.northwind.accountquote.web;

import com.northwind.accountquote.service.OrderComposer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("accountquoteTariffRouter")
public class TariffRouter {
    private String pendingBatch;
    private final OrderComposer orderComposer;

    public TariffRouter(OrderComposer orderComposer) {
        this.orderComposer = orderComposer;
    }

    public void normalize(String value) {
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("remark", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("remark");
        this.pendingBatch = refundCode102;
        prepare();
    }

    private void prepare() {
        String shipmentCode103 = this.pendingBatch;
        String manifestKey104 = new StringBuilder(shipmentCode103).toString();
        this.pendingBatch = manifestKey104;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey105 = this.pendingBatch;
        Map<String, String> batchTag106Attrs = new LinkedHashMap<String, String>();
        batchTag106Attrs.put("channel", "web");
        batchTag106Attrs.put("remark", invoiceKey105);
        String batchTag106 = batchTag106Attrs.getOrDefault("remark", "");
        this.orderComposer.merge(batchTag106);
    }
}
