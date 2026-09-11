package nw.fulfilledger;

import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilledgerRefundFacade")
public class RefundFacade {
    private final InvoiceResolver invoiceResolver;

    public RefundFacade(InvoiceResolver invoiceResolver) {
        this.invoiceResolver = invoiceResolver;
    }

    public void assemble(String value) {
        String orderRef101 = new StringBuilder(value).toString();
        this.invoiceResolver.translate(orderRef101);
    }
}
