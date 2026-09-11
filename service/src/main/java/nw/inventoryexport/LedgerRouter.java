package nw.inventoryexport;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("inventoryexportLedgerRouter")
public class LedgerRouter {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRouter.class);
    private final RefundGateway refundGateway;

    public LedgerRouter(RefundGateway refundGateway) {
        this.refundGateway = refundGateway;
    }

    public void route(String value) {
        LOG.debug("接收到一次库存处理请求");
        List<String> shipmentCode101Attrs = new ArrayList<String>();
        shipmentCode101Attrs.add("web");
        shipmentCode101Attrs.add(value);
        String shipmentCode101 = shipmentCode101Attrs.get(1);
        String manifestKey102 = "ref_" + shipmentCode101;
        this.refundGateway.register(manifestKey102);
    }
}
