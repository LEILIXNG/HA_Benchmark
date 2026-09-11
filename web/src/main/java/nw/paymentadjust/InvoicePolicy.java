package nw.paymentadjust;

import nw.platform.ValidationException;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentadjustInvoicePolicy")
public class InvoicePolicy {
    private final BundleGateway bundleGateway;

    public InvoicePolicy(BundleGateway bundleGateway) {
        this.bundleGateway = bundleGateway;
    }

    public void resolve(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.replace("'", "");
        this.bundleGateway.dispatch(cleaned);
    }
}
