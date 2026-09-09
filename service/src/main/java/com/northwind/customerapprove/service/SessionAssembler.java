package com.northwind.customerapprove.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerapproveSessionAssembler")
public class SessionAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(SessionAssembler.class);
    private static String cachedOrder;
    private final VoucherAdapter voucherAdapter;

    public SessionAssembler(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    public void dispatch(String value) {
        LOG.debug("接收到一次客户处理请求");
        String receiptKey201 = String.valueOf(value);
        String accountRef202 = receiptKey201;
        cachedOrder = accountRef202;
        translate();
    }

    private void translate() {
        String voucherRef203 = cachedOrder;
        Map<String, String> paymentTag204Attrs = new HashMap<String, String>();
        paymentTag204Attrs.put("channel", "web");
        paymentTag204Attrs.put("reference", voucherRef203);
        String paymentTag204 = paymentTag204Attrs.get("reference");
        Map<String, String> refundCode205Attrs = new LinkedHashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("detail", paymentTag204);
        String refundCode205 = refundCode205Attrs.getOrDefault("detail", "");
        this.voucherAdapter.assemble(refundCode205);
    }
}
