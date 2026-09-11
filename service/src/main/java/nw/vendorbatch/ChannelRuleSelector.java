package nw.vendorbatch;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("vendorbatchChannelRuleSelector")
public class ChannelRuleSelector {
    private static final String ACTIVE = "vendorbatchChannelRuleStandard";
    private final Map<String, ChannelRule> handlers;

    public ChannelRuleSelector(Map<String, ChannelRule> handlers) {
        this.handlers = handlers;
    }

    public void resolve(String value) {
        ChannelRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
