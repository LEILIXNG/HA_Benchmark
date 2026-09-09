package com.northwind.accountposting.web;

import com.northwind.accountposting.service.TariffCoordinator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("accountpostingTariffEnricher")
public class TariffEnricher {
    private String pendingTariff;
    private final TariffCoordinator tariffCoordinator;

    public TariffEnricher(TariffCoordinator tariffCoordinator) {
        this.tariffCoordinator = tariffCoordinator;
    }

    public void resolve(String value) {
        this.publish(value);
    }

    private void publish(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        Map<String, String> quoteRef2Attrs = new LinkedHashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.getOrDefault("remark", "");
        this.pendingTariff = quoteRef2;
        assemble();
    }

    private void assemble() {
        String tariffRef3 = this.pendingTariff;
        Map<String, String> ledgerEntry4Attrs = new LinkedHashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("reference", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.getOrDefault("reference", "");
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        this.pendingTariff = channelTag5;
        forward();
    }

    private void forward() {
        String catalogKey6 = this.pendingTariff;
        List<String> receiptKey7Attrs = new ArrayList<String>();
        receiptKey7Attrs.add("web");
        receiptKey7Attrs.add(catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get(1);
        Map<String, String> accountRef8Attrs = new HashMap<String, String>();
        accountRef8Attrs.put("channel", "web");
        accountRef8Attrs.put("reference", receiptKey7);
        String accountRef8 = accountRef8Attrs.get("reference");
        this.tariffCoordinator.reconcile(accountRef8);
    }
}
