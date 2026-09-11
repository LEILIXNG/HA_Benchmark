package nw.fulfilreview;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("fulfilreviewOrderCollector")
public class OrderCollector {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCollector.class);

    public void translate(String value) {
        LOG.trace("进入履约处理环节");
        List<String> paymentTag201Attrs = new ArrayList<String>();
        paymentTag201Attrs.add("web");
        paymentTag201Attrs.add(value);
        String paymentTag201 = paymentTag201Attrs.get(1);
        QuotePolicySelector.route(paymentTag201);
    }
}
