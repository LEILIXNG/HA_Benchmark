package nw.shippingrollup;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("shippingrollupAccountComposer")
public class AccountComposer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountComposer.class);
    private static String cachedShipment;
    private final RefundRouter refundRouter;

    public AccountComposer(RefundRouter refundRouter) {
        this.refundRouter = refundRouter;
    }

    public void attach(String value) {
        LOG.debug("接收到一次发运处理请求");
        String batchTag1 = String.format("ref_%s", value);
        List<String> orderRef2Attrs = new ArrayList<String>();
        orderRef2Attrs.add("web");
        orderRef2Attrs.add(batchTag1);
        String orderRef2 = orderRef2Attrs.get(1);
        cachedShipment = orderRef2;
        prepare();
    }

    private void prepare() {
        String quoteRef3 = cachedShipment;
        String tariffRef4 = quoteRef3;
        cachedShipment = tariffRef4;
        translate();
    }

    private void translate() {
        String ledgerEntry5 = cachedShipment;
        String channelTag6 = ledgerEntry5;
        this.refundRouter.stage(channelTag6);
    }
}
