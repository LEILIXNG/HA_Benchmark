package nw.ordernotice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("ordernoticeOrderNormalizer")
public class OrderNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderNormalizer.class);
    private final TariffCollector tariffCollector;

    public OrderNormalizer(TariffCollector tariffCollector) {
        this.tariffCollector = tariffCollector;
    }

    public void dispatch(String value) {
        LOG.debug("开始整理订单字段");
        String paymentTag301 = String.format("ref_%s", value);
        String refundCode302 = String.valueOf(paymentTag301);
        this.tariffCollector.route(refundCode302);
    }
}
