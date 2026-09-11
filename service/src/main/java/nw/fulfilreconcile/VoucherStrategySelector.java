package nw.fulfilreconcile;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("fulfilreconcileVoucherStrategySelector")
public class VoucherStrategySelector {
    private static final String ACTIVE = "fulfilreconcileVoucherStrategyStandard";
    private final Map<String, VoucherStrategy> handlers;

    public VoucherStrategySelector(Map<String, VoucherStrategy> handlers) {
        this.handlers = handlers;
    }

    public void compose(String value) {
        VoucherStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
