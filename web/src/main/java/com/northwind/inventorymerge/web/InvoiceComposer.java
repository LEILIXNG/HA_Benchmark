package com.northwind.inventorymerge.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("inventorymergeInvoiceComposer")
public class InvoiceComposer {
    private final TariffService tariffService;

    public InvoiceComposer(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    public void route(String value) {
        String catalogKey101 = value;
        List<String> receiptKey102Attrs = new ArrayList<String>();
        receiptKey102Attrs.add("web");
        receiptKey102Attrs.add(catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get(1);
        this.tariffService.dispatch(receiptKey102);
    }
}
