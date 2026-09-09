package com.northwind.customerapprove.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("customerapproveVoucherAdapter")
public class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);
    private static String cachedOrder;
    private final BatchTranslator batchTranslator;

    public VoucherAdapter(BatchTranslator batchTranslator) {
        this.batchTranslator = batchTranslator;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次客户处理请求");
        final String quoteRef301 = value;
        String tariffRef302 = new StringBuilder(quoteRef301).toString();
        cachedOrder = tariffRef302;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry303 = cachedOrder;
        Map<String, String> channelTag304Attrs = new HashMap<String, String>();
        channelTag304Attrs.put("channel", "web");
        channelTag304Attrs.put("reference", ledgerEntry303);
        String channelTag304 = channelTag304Attrs.get("reference");
        this.batchTranslator.compose(channelTag304);
    }
}
