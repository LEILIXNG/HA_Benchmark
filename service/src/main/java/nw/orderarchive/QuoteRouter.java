package nw.orderarchive;

import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("orderarchiveQuoteRouter")
public class QuoteRouter {
    private final OrderService orderService;

    public QuoteRouter(OrderService orderService) {
        this.orderService = orderService;
    }

    public void normalize(String value) {
        StringBuilder invoiceKey401Buffer = new StringBuilder("ref_");
        invoiceKey401Buffer.append(value);
        String invoiceKey401 = invoiceKey401Buffer.toString();
        String batchTag402 = "ref_" + invoiceKey401;
        this.orderService.normalize(batchTag402);
    }
}
