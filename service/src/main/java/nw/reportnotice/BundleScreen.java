package nw.reportnotice;

import nw.platform.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportnoticeBundleScreen")
public class BundleScreen {
    private final ReceiptGateway receiptGateway;

    public BundleScreen(ReceiptGateway receiptGateway) {
        this.receiptGateway = receiptGateway;
    }

    public void route(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        this.receiptGateway.merge(value);
    }
}
