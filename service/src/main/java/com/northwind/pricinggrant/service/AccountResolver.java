package com.northwind.pricinggrant.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricinggrantAccountResolver")
public class AccountResolver {
    private static final Logger LOG = LoggerFactory.getLogger(AccountResolver.class);
    private final AccountExecutor accountExecutor;

    public AccountResolver(AccountExecutor accountExecutor) {
        this.accountExecutor = accountExecutor;
    }

    public void reconcile(String value) {
        LOG.trace("进入定价处理环节");
        StringBuilder catalogKey401Buffer = new StringBuilder("ref_");
        catalogKey401Buffer.append(value);
        String catalogKey401 = catalogKey401Buffer.toString();
        Map<String, String> receiptKey402Attrs = new LinkedHashMap<String, String>();
        receiptKey402Attrs.put("channel", "web");
        receiptKey402Attrs.put("remark", catalogKey401);
        String receiptKey402 = receiptKey402Attrs.getOrDefault("remark", "");
        this.accountExecutor.attach(receiptKey402);
    }
}
