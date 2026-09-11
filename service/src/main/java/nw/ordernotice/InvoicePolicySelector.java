package nw.ordernotice;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("ordernoticeInvoicePolicySelector")
public class InvoicePolicySelector {
    private static final String ACTIVE = "ordernoticeInvoicePolicyStandard";
    private final Map<String, InvoicePolicy> handlers;

    public InvoicePolicySelector(Map<String, InvoicePolicy> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        InvoicePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
