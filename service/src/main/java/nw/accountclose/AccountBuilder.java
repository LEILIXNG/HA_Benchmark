package nw.accountclose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("accountcloseAccountBuilder")
public class AccountBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(AccountBuilder.class);
    private String pendingShipment;
    private final ShipmentGateway shipmentGateway;

    public AccountBuilder(ShipmentGateway shipmentGateway) {
        this.shipmentGateway = shipmentGateway;
    }

    public void collect(String value) {
        LOG.debug("接收到一次账户处理请求");
        this.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("detail", value);
        String tariffRef101 = tariffRef101Attrs.get("detail");
        String ledgerEntry102 = tariffRef101;
        this.pendingShipment = ledgerEntry102;
        prepare();
    }

    private void prepare() {
        String channelTag103 = this.pendingShipment;
        String catalogKey104 = String.format("ref_%s", channelTag103);
        List<String> receiptKey105Attrs = new ArrayList<String>();
        receiptKey105Attrs.add("web");
        receiptKey105Attrs.add(catalogKey104);
        String receiptKey105 = receiptKey105Attrs.get(1);
        this.shipmentGateway.translate(receiptKey105);
    }
}
