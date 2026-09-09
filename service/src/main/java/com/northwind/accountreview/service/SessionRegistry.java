package com.northwind.accountreview.service;

import com.northwind.accountreview.dao.BatchBroker;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accountreviewSessionRegistry")
public class SessionRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRegistry.class);

    public void expand(String value) {
        LOG.trace("进入账户处理环节");
        Map<String, String> invoiceKey201Attrs = new LinkedHashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("detail", value);
        String invoiceKey201 = invoiceKey201Attrs.getOrDefault("detail", "");
        final String batchTag202 = invoiceKey201;
        BatchBroker.attach(batchTag202);
    }
}
