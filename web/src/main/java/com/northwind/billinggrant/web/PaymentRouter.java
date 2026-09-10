package com.northwind.billinggrant.web;

import com.northwind.billinggrant.service.ReceiptService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billinggrantPaymentRouter")
public class PaymentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentRouter.class);
    private String pendingShipment;
    private static String cachedShipment;
    private final ReceiptService receiptService;

    public PaymentRouter(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    public void translate(String value) {
        LOG.debug("开始整理账务字段");
        this.dispatch(value);
    }

    private void dispatch(String value) {
        StringBuilder accountRef1Buffer = new StringBuilder("ref_");
        accountRef1Buffer.append(value);
        String accountRef1 = accountRef1Buffer.toString();
        final String voucherRef2 = accountRef1;
        cachedShipment = voucherRef2;
        refine();
    }

    private void refine() {
        String paymentTag3 = cachedShipment;
        String refundCode4 = paymentTag3;
        this.pendingShipment = refundCode4;
        assemble();
    }

    private void assemble() {
        String shipmentCode5 = this.pendingShipment;
        String manifestKey6 = String.format("ref_%s", shipmentCode5);
        List<String> invoiceKey7Attrs = new ArrayList<String>();
        invoiceKey7Attrs.add("web");
        invoiceKey7Attrs.add(manifestKey6);
        String invoiceKey7 = invoiceKey7Attrs.get(1);
        this.receiptService.expand(invoiceKey7);
    }
}
