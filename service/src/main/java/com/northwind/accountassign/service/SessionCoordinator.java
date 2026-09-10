package com.northwind.accountassign.service;

import com.northwind.accountassign.dao.RefundBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("accountassignSessionCoordinator")
public class SessionCoordinator {
    private static String cachedManifest;
    private final RefundBuilder refundBuilder;

    public SessionCoordinator(RefundBuilder refundBuilder) {
        this.refundBuilder = refundBuilder;
    }

    public void submit(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("detail", value);
        String orderRef101 = orderRef101Attrs.get("detail");
        List<String> quoteRef102Attrs = new ArrayList<String>();
        quoteRef102Attrs.add("web");
        quoteRef102Attrs.add(orderRef101);
        String quoteRef102 = quoteRef102Attrs.get(1);
        cachedManifest = quoteRef102;
        prepare();
    }

    private void prepare() {
        String tariffRef103 = cachedManifest;
        String ledgerEntry104 = String.valueOf(tariffRef103);
        cachedManifest = ledgerEntry104;
        attach();
    }

    private void attach() {
        String channelTag105 = cachedManifest;
        String catalogKey106 = "ref_" + channelTag105;
        cachedManifest = catalogKey106;
        merge();
    }

    private void merge() {
        String receiptKey107 = cachedManifest;
        List<String> accountRef108Attrs = new ArrayList<String>();
        accountRef108Attrs.add("web");
        accountRef108Attrs.add(receiptKey107);
        String accountRef108 = accountRef108Attrs.get(1);
        this.refundBuilder.attach(accountRef108);
    }
}
