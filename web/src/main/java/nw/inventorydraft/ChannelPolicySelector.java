package nw.inventorydraft;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("inventorydraftChannelPolicySelector")
public class ChannelPolicySelector {
    private static final String ACTIVE = "inventorydraftChannelPolicyStandard";
    private final Map<String, ChannelPolicy> handlers;

    public ChannelPolicySelector(Map<String, ChannelPolicy> handlers) {
        this.handlers = handlers;
    }

    public void route(String value) {
        ChannelPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
