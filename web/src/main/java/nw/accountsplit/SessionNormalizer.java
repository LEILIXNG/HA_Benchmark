package nw.accountsplit;

import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountsplitSessionNormalizer")
public class SessionNormalizer {
    private final ManifestStrategySelector manifestStrategySelector;

    public SessionNormalizer(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void register(String value) {
        final String shipmentCode101 = value;
        this.manifestStrategySelector.attach(shipmentCode101);
    }
}
