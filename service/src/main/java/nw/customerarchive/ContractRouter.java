package nw.customerarchive;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("customerarchiveContractRouter")
public class ContractRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRouter.class);
    private static String cachedSession;
    private final PaymentStrategySelector paymentStrategySelector;

    public ContractRouter(PaymentStrategySelector paymentStrategySelector) {
        this.paymentStrategySelector = paymentStrategySelector;
    }

    public void collect(String value) {
        LOG.debug("接收到一次客户处理请求");
        String refundCode101 = new StringBuilder(value).toString();
        cachedSession = refundCode101;
        enrich();
    }

    private void enrich() {
        String shipmentCode102 = cachedSession;
        List<String> manifestKey103Attrs = new ArrayList<String>();
        manifestKey103Attrs.add("web");
        manifestKey103Attrs.add(shipmentCode102);
        String manifestKey103 = manifestKey103Attrs.get(1);
        cachedSession = manifestKey103;
        expand();
    }

    private void expand() {
        String invoiceKey104 = cachedSession;
        List<String> batchTag105Attrs = new ArrayList<String>();
        batchTag105Attrs.add("web");
        batchTag105Attrs.add(invoiceKey104);
        String batchTag105 = batchTag105Attrs.get(1);
        List<String> orderRef106Attrs = new ArrayList<String>();
        orderRef106Attrs.add("web");
        orderRef106Attrs.add(batchTag105);
        String orderRef106 = orderRef106Attrs.get(1);
        this.paymentStrategySelector.route(orderRef106);
    }
}
