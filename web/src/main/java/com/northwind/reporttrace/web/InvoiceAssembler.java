package com.northwind.reporttrace.web;

import com.northwind.reporttrace.service.TariffAdapter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reporttraceInvoiceAssembler")
public class InvoiceAssembler {
    private final TariffAdapter tariffAdapter;

    public InvoiceAssembler(TariffAdapter tariffAdapter) {
        this.tariffAdapter = tariffAdapter;
    }

    public void normalize(String value) {
        List<String> tariffRef201Attrs = new ArrayList<String>();
        tariffRef201Attrs.add("web");
        tariffRef201Attrs.add(value);
        String tariffRef201 = tariffRef201Attrs.get(1);
        this.tariffAdapter.refine(tariffRef201);
    }
}
