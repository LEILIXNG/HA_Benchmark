package nw.billingsplit;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("billingsplitChannelStrategySelector")
public class ChannelStrategySelector {
    private static final String ACTIVE = "billingsplitChannelStrategyStandard";
    private final Map<String, ChannelStrategy> handlers;

    public ChannelStrategySelector(Map<String, ChannelStrategy> handlers) {
        this.handlers = handlers;
    }

    public void resolve(String value) {
        ChannelStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
