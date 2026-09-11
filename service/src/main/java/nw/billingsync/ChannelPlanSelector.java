package nw.billingsync;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("billingsyncChannelPlanSelector")
public class ChannelPlanSelector {
    private static final String ACTIVE = "billingsyncChannelPlanStandard";
    private final Map<String, ChannelPlan> handlers;

    public ChannelPlanSelector(Map<String, ChannelPlan> handlers) {
        this.handlers = handlers;
    }

    public void forward(String value) {
        ChannelPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
