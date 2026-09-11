package nw.reporttransfer;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ChannelTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelTranslator.class);

    public static void resolve(String value) {
        LOG.debug("接收到一次报表处理请求");
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("detail", value);
        String paymentTag401 = paymentTag401Attrs.get("detail");
        String refundCode402 = String.format("ref_%s", paymentTag401);
        InvoiceRepository.stage(refundCode402);
    }
}
