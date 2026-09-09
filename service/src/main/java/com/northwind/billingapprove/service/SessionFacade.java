package com.northwind.billingapprove.service;

import com.northwind.billingapprove.dao.VoucherRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("billingapproveSessionFacade")
public class SessionFacade {
    private static final Logger LOG = LoggerFactory.getLogger(SessionFacade.class);
    private final VoucherRegistry voucherRegistry;

    public SessionFacade(VoucherRegistry voucherRegistry) {
        this.voucherRegistry = voucherRegistry;
    }

    public void expand(String value) {
        LOG.debug("账务流程转下一环节");
        StringBuilder ledgerEntry101Buffer = new StringBuilder("ref:");
        ledgerEntry101Buffer.append(value).append(";");
        String ledgerEntry101 = ledgerEntry101Buffer.toString();
        Map<String, String> channelTag102Attrs = new LinkedHashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("remark", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.getOrDefault("remark", "");
        this.voucherRegistry.translate(channelTag102);
    }
}
