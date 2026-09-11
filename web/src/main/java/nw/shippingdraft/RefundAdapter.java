package nw.shippingdraft;

import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingdraftRefundAdapter")
public class RefundAdapter {
    private String pendingCatalog;
    private final SessionBuilder sessionBuilder;

    public RefundAdapter(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public void collect(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String manifestKey1 = String.valueOf(value);
        this.pendingCatalog = manifestKey1;
        compose();
    }

    private void compose() {
        String invoiceKey2 = this.pendingCatalog;
        String batchTag3 = String.valueOf(invoiceKey2);
        this.sessionBuilder.attach(batchTag3);
    }
}
