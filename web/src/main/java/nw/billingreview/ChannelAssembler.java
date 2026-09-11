package nw.billingreview;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billingreviewChannelAssembler")
public class ChannelAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelAssembler.class);
    private final LedgerFacade ledgerFacade;

    public ChannelAssembler(LedgerFacade ledgerFacade) {
        this.ledgerFacade = ledgerFacade;
    }

    public void refine(String value) {
        LOG.debug("接收到一次账务处理请求");
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        this.ledgerFacade.collect(orderRef1);
    }
}
