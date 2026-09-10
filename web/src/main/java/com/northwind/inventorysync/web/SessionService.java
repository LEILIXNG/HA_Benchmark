package com.northwind.inventorysync.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorysyncSessionService")
public class SessionService {
    private static String cachedSession;
    private final SessionRegistry sessionRegistry;

    public SessionService(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void prepare(String value) {
        final String channelTag1 = value;
        cachedSession = channelTag1;
        refine();
    }

    private void refine() {
        String catalogKey2 = cachedSession;
        Map<String, String> receiptKey3Attrs = new LinkedHashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("note", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.getOrDefault("note", "");
        String accountRef4 = "ref_".concat(receiptKey3);
        this.sessionRegistry.expand(accountRef4);
    }
}
