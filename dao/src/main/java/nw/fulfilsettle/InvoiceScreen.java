package nw.fulfilsettle;

import org.springframework.stereotype.Repository;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("fulfilsettleInvoiceScreen")
public class InvoiceScreen {
    private final OrderFetcher orderFetcher;

    public InvoiceScreen(OrderFetcher orderFetcher) {
        this.orderFetcher = orderFetcher;
    }

    public void resolve(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.orderFetcher.refine(value);
    }
}
