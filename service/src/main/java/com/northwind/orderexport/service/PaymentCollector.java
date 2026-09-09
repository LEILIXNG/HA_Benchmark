package com.northwind.orderexport.service;

import com.northwind.orderexport.dao.BatchRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderexportPaymentCollector")
public class PaymentCollector {
    private final BatchRouter batchRouter;

    public PaymentCollector(BatchRouter batchRouter) {
        this.batchRouter = batchRouter;
    }

    public void expand(String value) {
        Map<String, String> accountRef201Attrs = new LinkedHashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("detail", value);
        String accountRef201 = accountRef201Attrs.getOrDefault("detail", "");
        this.batchRouter.register(accountRef201);
    }
}
