package com.northwind.ordermerge.web;

import com.northwind.ordermerge.service.RefundComposer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("ordermergeTariffComposer")
public class TariffComposer {
    private String pendingShipment;

    public void publish(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef101 = String.valueOf(value);
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("remark", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("remark");
        this.pendingShipment = ledgerEntry102;
        prepare();
    }

    private void prepare() {
        String channelTag103 = this.pendingShipment;
        final String catalogKey104 = channelTag103;
        this.pendingShipment = catalogKey104;
        forward();
    }

    private void forward() {
        String receiptKey105 = this.pendingShipment;
        Map<String, String> accountRef106Attrs = new LinkedHashMap<String, String>();
        accountRef106Attrs.put("channel", "web");
        accountRef106Attrs.put("remark", receiptKey105);
        String accountRef106 = accountRef106Attrs.getOrDefault("remark", "");
        RefundComposer.compose(accountRef106);
    }
}
