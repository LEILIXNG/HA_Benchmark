package nw.vendorsplit;

import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorsplitReceiptAssembler")
public class ReceiptAssembler {
    private final RefundBroker refundBroker;

    public ReceiptAssembler(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    public void attach(String value) {
        String voucherRef1 = value;
        this.refundBroker.reconcile(voucherRef1);
    }
}
