package com.northwind.orderbind.service;

import com.northwind.orderbind.dao.TariffBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderbindAccountAssembler")
public class AccountAssembler {
    private String pendingBatch;
    private final TariffBuilder tariffBuilder;

    public AccountAssembler(TariffBuilder tariffBuilder) {
        this.tariffBuilder = tariffBuilder;
    }

    public void attach(String value) {
        this.translate(value);
    }

    private void translate(String value) {
        Map<String, String> invoiceKey101Attrs = new LinkedHashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("detail", value);
        String invoiceKey101 = invoiceKey101Attrs.getOrDefault("detail", "");
        this.pendingBatch = invoiceKey101;
        forward();
    }

    private void forward() {
        String batchTag102 = this.pendingBatch;
        String orderRef103 = String.format("ref:%s;", batchTag102);
        this.tariffBuilder.assemble(orderRef103);
    }
}
