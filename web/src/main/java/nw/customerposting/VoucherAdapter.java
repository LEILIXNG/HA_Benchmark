package nw.customerposting;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);

    public static void forward(String value) {
        LOG.debug("接收到一次客户处理请求");
        List<String> orderRef101Attrs = new ArrayList<String>();
        orderRef101Attrs.add("web");
        orderRef101Attrs.add(value);
        String orderRef101 = orderRef101Attrs.get(1);
        List<String> quoteRef102Attrs = new ArrayList<String>();
        quoteRef102Attrs.add("web");
        quoteRef102Attrs.add(orderRef101);
        String quoteRef102 = quoteRef102Attrs.get(1);
        RefundNormalizer.publish(quoteRef102);
    }
}
