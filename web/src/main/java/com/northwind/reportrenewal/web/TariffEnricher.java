package com.northwind.reportrenewal.web;

import com.northwind.reportrenewal.service.ShipmentBroker;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("reportrenewalTariffEnricher")
public class TariffEnricher {
    private String pendingVoucher;
    private static String cachedVoucher;
    private final ShipmentBroker shipmentBroker;

    public TariffEnricher(ShipmentBroker shipmentBroker) {
        this.shipmentBroker = shipmentBroker;
    }

    public void forward(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String orderRef1 = String.valueOf(value);
        String quoteRef2 = orderRef1;
        this.pendingVoucher = quoteRef2;
        submit();
    }

    private void submit() {
        String tariffRef3 = this.pendingVoucher;
        final String ledgerEntry4 = tariffRef3;
        cachedVoucher = ledgerEntry4;
        register();
    }

    private void register() {
        String channelTag5 = cachedVoucher;
        final String catalogKey6 = channelTag5;
        List<String> receiptKey7Attrs = new ArrayList<String>();
        receiptKey7Attrs.add("web");
        receiptKey7Attrs.add(catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get(1);
        this.shipmentBroker.assemble(receiptKey7);
    }
}
