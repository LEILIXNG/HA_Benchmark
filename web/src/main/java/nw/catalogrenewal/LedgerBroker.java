package nw.catalogrenewal;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogrenewalLedgerBroker")
public class LedgerBroker {
    private final LedgerRouter ledgerRouter;

    public LedgerBroker(LedgerRouter ledgerRouter) {
        this.ledgerRouter = ledgerRouter;
    }

    public void submit(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.get("detail");
        this.ledgerRouter.normalize(refundCode101);
    }
}
