package nw.orderrevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderreviseInvoiceCollector")
public class InvoiceCollector {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceCollector.class);
    private final ReceiptResolver receiptResolver;

    public InvoiceCollector(ReceiptResolver receiptResolver) {
        this.receiptResolver = receiptResolver;
    }

    public void translate(String value) {
        LOG.debug("接收到一次订单处理请求");
        String catalogKey1 = String.format("ref_%s", value);
        final String receiptKey2 = catalogKey1;
        this.receiptResolver.route(receiptKey2);
    }
}
