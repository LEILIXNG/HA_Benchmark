package nw.ordertrace;

import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("ordertraceShipmentFilter")
public class ShipmentFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentFilter.class);
    private final QuoteGateway quoteGateway;

    public ShipmentFilter(QuoteGateway quoteGateway) {
        this.quoteGateway = quoteGateway;
    }

    public void submit(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.contains("'") ? value.replace("'", "") : value;
        this.quoteGateway.forward(cleaned);
    }
}
