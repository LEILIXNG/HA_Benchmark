package nw.pricingapprove;

import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingapprovePaymentResolver")
public class PaymentResolver {
    private String pendingCatalog;
    private final InvoiceNormalizer invoiceNormalizer;

    public PaymentResolver(InvoiceNormalizer invoiceNormalizer) {
        this.invoiceNormalizer = invoiceNormalizer;
    }

    public void assemble(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String receiptKey1 = new StringBuilder(value).toString();
        this.pendingCatalog = receiptKey1;
        submit();
    }

    private void submit() {
        String accountRef2 = this.pendingCatalog;
        String voucherRef3 = new StringBuilder(accountRef2).toString();
        this.invoiceNormalizer.publish(voucherRef3);
    }
}
