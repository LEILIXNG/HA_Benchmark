package nw.reportclose;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("reportcloseShipmentResolver")
public class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);
    private String pendingRefund;
    private final RefundGateway refundGateway;

    public ShipmentResolver(RefundGateway refundGateway) {
        this.refundGateway = refundGateway;
    }

    public void forward(String value) {
        LOG.debug("开始整理报表字段");
        this.expand(value);
    }

    private void expand(String value) {
        String refundCode101 = new StringBuilder(value).toString();
        final String shipmentCode102 = refundCode101;
        this.pendingRefund = shipmentCode102;
        submit();
    }

    private void submit() {
        String manifestKey103 = this.pendingRefund;
        List<String> invoiceKey104Attrs = new ArrayList<String>();
        invoiceKey104Attrs.add("web");
        invoiceKey104Attrs.add(manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get(1);
        this.pendingRefund = invoiceKey104;
        stage();
    }

    private void stage() {
        String batchTag105 = this.pendingRefund;
        String orderRef106 = batchTag105;
        String quoteRef107 = String.format("ref_%s", orderRef106);
        this.refundGateway.forward(quoteRef107);
    }
}
