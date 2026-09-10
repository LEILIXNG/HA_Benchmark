package com.northwind.fulfilsettlequeue.web;

import com.northwind.fulfilsettlequeue.service.ManifestRouter;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("fulfilsettlequeueManifestService")
public class ManifestService {
    private String pendingCatalog;
    private static String cachedCatalog;
    private final ManifestRouter manifestRouter;

    public ManifestService(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    public void assemble(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        String catalogKey1 = "ref_" + value;
        String receiptKey2 = String.valueOf(catalogKey1);
        this.pendingCatalog = receiptKey2;
        compose();
    }

    private void compose() {
        String accountRef3 = this.pendingCatalog;
        String voucherRef4 = new StringBuilder(accountRef3).toString();
        cachedCatalog = voucherRef4;
        expand();
    }

    private void expand() {
        String paymentTag5 = cachedCatalog;
        String refundCode6 = new StringBuilder(paymentTag5).toString();
        cachedCatalog = refundCode6;
        refine();
    }

    private void refine() {
        String shipmentCode7 = cachedCatalog;
        String manifestKey8 = "ref_" + shipmentCode7;
        cachedCatalog = manifestKey8;
        register();
    }

    private void register() {
        String invoiceKey9 = cachedCatalog;
        String batchTag10 = "ref_" + invoiceKey9;
        StringBuilder orderRef11Buffer = new StringBuilder("ref_");
        orderRef11Buffer.append(batchTag10);
        String orderRef11 = orderRef11Buffer.toString();
        this.pendingCatalog = orderRef11;
        forward();
    }

    private void forward() {
        String quoteRef12 = this.pendingCatalog;
        StringBuilder tariffRef13Buffer = new StringBuilder("ref_");
        tariffRef13Buffer.append(quoteRef12);
        String tariffRef13 = tariffRef13Buffer.toString();
        this.manifestRouter.forward(tariffRef13);
    }
}
