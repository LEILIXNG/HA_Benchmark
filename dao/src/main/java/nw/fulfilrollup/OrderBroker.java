package nw.fulfilrollup;

import org.springframework.stereotype.Repository;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("fulfilrollupOrderBroker")
public class OrderBroker {
    private final PaymentCollector paymentCollector;

    public OrderBroker(PaymentCollector paymentCollector) {
        this.paymentCollector = paymentCollector;
    }

    public void submit(String value) {
        final String manifestKey301 = value;
        String invoiceKey302 = new StringBuilder(manifestKey301).toString();
        this.paymentCollector.route(invoiceKey302);
    }
}
