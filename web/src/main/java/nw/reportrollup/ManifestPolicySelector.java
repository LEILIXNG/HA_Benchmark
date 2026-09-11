package nw.reportrollup;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportrollupManifestPolicySelector")
public class ManifestPolicySelector {
    private static final String ACTIVE = "reportrollupManifestPolicyStandard";
    private final Map<String, ManifestPolicy> handlers;

    public ManifestPolicySelector(Map<String, ManifestPolicy> handlers) {
        this.handlers = handlers;
    }

    public void refine(String value) {
        ManifestPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
