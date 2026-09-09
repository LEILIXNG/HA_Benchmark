package com.northwind.vendoradjust.web;

import com.northwind.vendoradjust.service.ChannelRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendoradjustManifestEnricher")
public class ManifestEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEnricher.class);
    private static String cachedInvoice;
    private final ChannelRouter channelRouter;

    public ManifestEnricher(ChannelRouter channelRouter) {
        this.channelRouter = channelRouter;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次供应商处理请求");
        final String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new LinkedHashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("remark", paymentTag201);
        String refundCode202 = refundCode202Attrs.getOrDefault("remark", "");
        cachedInvoice = refundCode202;
        attach();
    }

    private void attach() {
        String shipmentCode203 = cachedInvoice;
        String manifestKey204 = String.valueOf(shipmentCode203);
        String invoiceKey205 = manifestKey204;
        this.channelRouter.reconcile(invoiceKey205);
    }
}
