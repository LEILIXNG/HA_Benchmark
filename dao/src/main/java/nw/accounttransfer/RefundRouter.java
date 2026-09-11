package nw.accounttransfer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("accounttransferRefundRouter")
public class RefundRouter {
    private final QuoteValidator quoteValidator;

    public RefundRouter(QuoteValidator quoteValidator) {
        this.quoteValidator = quoteValidator;
    }

    public void refine(String value) {
        String refundCode401 = new StringBuilder(value).toString();
        List<String> shipmentCode402Attrs = new ArrayList<String>();
        shipmentCode402Attrs.add("web");
        shipmentCode402Attrs.add(refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get(1);
        this.quoteValidator.assemble(shipmentCode402);
    }
}
