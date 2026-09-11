package nw.reportsubmit;

import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reportsubmitVoucherService")
public class VoucherService {
    private String pendingInvoice;
    private static String cachedInvoice;

    public void merge(String value) {
        this.route(value);
    }

    private void route(String value) {
        String channelTag101 = String.valueOf(value);
        this.pendingInvoice = channelTag101;
        stage();
    }

    private void stage() {
        String catalogKey102 = this.pendingInvoice;
        String receiptKey103 = String.valueOf(catalogKey102);
        final String accountRef104 = receiptKey103;
        cachedInvoice = accountRef104;
        submit();
    }

    private void submit() {
        String voucherRef105 = cachedInvoice;
        final String paymentTag106 = voucherRef105;
        InvoiceFetcher.expand(paymentTag106);
    }
}
