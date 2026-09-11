package nw.reportsplit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCoordinator.class);
    private static String cachedReceipt;

    public static void stage(String value) {
        LOG.debug("接收到一次报表处理请求");
        String paymentTag101 = "ref_" + value;
        cachedReceipt = paymentTag101;
        normalize();
    }

    private static void normalize() {
        String refundCode102 = cachedReceipt;
        String shipmentCode103 = new StringBuilder(refundCode102).toString();
        List<String> manifestKey104Attrs = new ArrayList<String>();
        manifestKey104Attrs.add("web");
        manifestKey104Attrs.add(shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get(1);
        cachedReceipt = manifestKey104;
        expand();
    }

    private static void expand() {
        String invoiceKey105 = cachedReceipt;
        String batchTag106 = "ref_".concat(invoiceKey105);
        SessionEnricher.register(batchTag106);
    }
}
